
package com.sacral.java.repository;

import com.sacral.java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add any additional custom queries or methods here
    
    // Example: Find user by username
    User findByUsername(String username);
    
    // Example: Find user by email
    User findByEmail(String email);
    
    // Example: Find user by username and password
    User findByUsernameAndPassword(String username, String password);
    
    // Example: Find user by email and password
    User findByEmailAndPassword(String email, String password);
    
    // Example: Find user by username or email
    User findByUsernameOrEmail(String username, String email);
    
    // Example: Find user by username or email and password
    User findByUsernameOrEmailAndPassword(String username, String email, String password);
    
    // Example: Find user by username containing a specific keyword
    List<User> findByUsernameContaining(String keyword);
    
    // Example: Find user by email containing a specific keyword
    List<User> findByEmailContaining(String keyword);
    
    // Example: Find user by username or email containing a specific keyword
    List<User> findByUsernameContainingOrEmailContaining(String keyword1, String keyword2);
    
    // Example: Find user by username or email containing a specific keyword and password
    List<User> findByUsernameContainingOrEmailContainingAndPassword(String keyword1, String keyword2, String password);
    
    // Add more custom queries or methods as per your requirements
}
