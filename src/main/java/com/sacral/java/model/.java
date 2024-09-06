hon
from flask import Flask, request, jsonify
from flask_mail import Mail, Message

app = Flask(__name__)
app.config['MAIL_SERVER'] = 'smtp.example.com'
app.config['MAIL_PORT'] = 587
app.config['MAIL_USERNAME'] = 'your-email@example.com'
app.config['MAIL_PASSWORD'] = 'your-password'
app.config['MAIL_USE_TLS'] = True
app.config['MAIL_USE_SSL'] = False

mail = Mail(app)

cases = {}
case_id_counter = 1

@app.route('/ff_approval_request_form', methods=['GET'])
def get_ff_approval_request_form():
    return '''
    <form action="/submit_ff_approval_request" method="post">
        Case Remarks: <input type="text" name="case_remarks"><br>
        <input type="submit" value="Submit">
    </form>
    '''

@app.route('/submit_ff_approval_request', methods=['POST'])
def submit_ff_approval_request():
    global case_id_counter
    case_remarks = request.form['case_remarks']
    case_id = case_id_counter
    case_id_counter += 1
    cases[case_id] = {
        'remarks': case_remarks,
        'status': 'F&F Approval Pending with QC2',
        'decision': None
    }
    send_email(case_id, case_remarks)
    return jsonify({'message': 'Request submitted successfully', 'case_id': case_id})

def send_email(case_id, case_remarks):
    msg = Message('F&F Approval Request', sender='your-email@example.com', recipients=['qc2@example.com'])
    msg.body = f'Case ID: {case_id}\nRemarks: {case_remarks}'
    mail.send(msg)

@app.route('/review_ff_approval_request/<int:case_id>', methods=['POST'])
def review_ff_approval_request(case_id):
    decision = request.form['decision']
    remarks = request.form['remarks']
    if case_id in cases:
        cases[case_id]['decision'] = decision
        cases[case_id]['remarks'] = remarks
        cases[case_id]['status'] = 'Approved' if decision == 'approve' else 'Rejected'
        return jsonify({'message': 'Decision recorded successfully'})
    return jsonify({'message': 'Case not found'}), 404

if __name__ == '__main__':
    app.run(debug=True)
