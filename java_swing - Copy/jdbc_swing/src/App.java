// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.*;
// import java.sql.*;

// public class App extends JFrame implements ActionListener {
//     JTextField textfield, emailField;
//     JPasswordField passwordField;


//     public App() {
//         this.setSize(400, 400);
//         this.setTitle("Welcome To Login Screen");
//         this.setLayout(null);

//         JLabel l1 = new JLabel();
//         l1.setText("Username: ");
//         l1.setBounds(20,20,80,60);
//         this.add(l1);

//         textfield = new JTextField();
//         textfield.setName("Username");
//         textfield.setBounds(105,40,80,20);
//         this.add(textfield);

//         JLabel l2 = new JLabel();
//         l2.setText("Email: ");
//         l2.setBounds(20,40,80,60);
//         this.add(l2);

//         emailField = new JTextField();
//         emailField.setName("Email");
//         emailField.setBounds(105,60,80,20);
//         this.add(emailField);

//         JLabel l3 = new JLabel();
// 		l3.setText("Password: ");
// 		l3.setBounds(20,60,80,60);
// 		this.add(l3);

//         passwordField = new JPasswordField();
//         passwordField.setName("Password");
//         passwordField.setBounds(105,80,80,20);
//         this.add(passwordField);

//         JButton b1 = new JButton();
//         b1.setText("Submit");
//         b1.setBounds(20,180,100,20);
//         this.add(b1);

//         b1.addActionListener(this);
//         this.setVisible(true);
//     }

//     public static void main(String[] args) {
//         App sf1 = new App();
//     }

//     @Override
//     public void actionPerformed(ActionEvent arg0) {
//         String User = "root";
// 		String password = "12345Qwert";
// 		String url = "jdbc:mysql://localhost:3306/user";
// 		String query = "INSERT INTO Users(username, email, pwd) VALUES(?, ?, ?)";
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");		
//             Connection con = DriverManager.getConnection(url,User,password);
            
//             PreparedStatement statement = con.prepareStatement(query);
//             statement.setString(1, textfield.getText());
//             statement.setString(2, emailField.getText());
//             statement.setString(3, passwordField.getText());
//             statement.executeUpdate();
//         }catch (Exception er) {
//             er.printStackTrace();
//         }
//     }
// }




package com.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class App extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String email = req.getParameter("user_email");
        String cond = req.getParameter("condition");
        if(cond != null){
            String User = "root";
            String pass = "12345Qwert";
            String url = "jdbc:mysql://localhost:3306/user_manage";
            String query = "INSERT INTO Users(username, email, passwd) VALUES(?, ?, ?)";
            try {
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con = DriverManager.getConnection(url,User,pass);
				
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, name);
		statement.setString(2, email);
		statement.setString(3, password);
		statement.executeUpdate();
            }catch (Exception er) {
		er.printStackTrace();
            }
        }else{
            out.println("<h2>You have not agreed to terms and conditons<h2>");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("index.html");
        rd.include(req,res);
    }
    
}
