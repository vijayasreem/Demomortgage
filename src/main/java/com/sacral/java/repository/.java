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

@app.route('/ff_approval_request_form', methods=['GET'])
def get_ff_approval_request_form():
    return '''
    <form action="/submit_ff_approval_request" method="post">
        Case ID: <input type="text" name="case_id"><br>
        Case Remarks: <textarea name="case_remarks"></textarea><br>
        <input type="submit" value="Submit">
    </form>
    '''

@app.route('/submit_ff_approval_request', methods=['POST'])
def submit_ff_approval_request():
    case_id = request.form['case_id']
    case_remarks = request.form['case_remarks']
    cases[case_id] = {'status': 'F&F Approval Pending with QC2', 'remarks': case_remarks}
    send_email(case_id, case_remarks)
    return 'F&F approval request submitted.'

def send_email(case_id, case_remarks):
    msg = Message('F&F Approval Request', sender='your-email@example.com', recipients=['qc2@example.com'])
    msg.body = f'Case ID: {case_id}\nRemarks: {case_remarks}'
    mail.send(msg)

@app.route('/review_ff_approval_request/<case_id>', methods=['POST'])
def review_ff_approval_request(case_id):
    decision = request.form['decision']
    qc2_remarks = request.form['qc2_remarks']
    cases[case_id]['status'] = 'Approved' if decision == 'approve' else 'Rejected'
    cases[case_id]['qc2_remarks'] = qc2_remarks
    return 'F&F approval request reviewed.'

if __name__ == '__main__':
    app.run(debug=True)
