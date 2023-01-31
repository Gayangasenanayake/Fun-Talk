package Login;

import Admin.AdminDashboard;
import Pojo.User;
import Register.Register;
import User.UserDashboard;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Login extends javax.swing.JFrame {

    private String uid;
    int xmouse;
    int ymouse;
    
    public Login() {
        initComponents();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtuname = new javax.swing.JTextField();
        txtpwd = new javax.swing.JPasswordField();
        logButton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtuname.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtuname.setForeground(new java.awt.Color(51, 51, 51));
        txtuname.setBorder(null);
        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });
        jPanel1.add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 250, 30));

        txtpwd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtpwd.setForeground(new java.awt.Color(51, 51, 51));
        txtpwd.setBorder(null);
        jPanel1.add(txtpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 240, 20));

        logButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logButtonMouseClicked(evt);
            }
        });
        jPanel1.add(logButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 260, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/icons8_close_window_25px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/login_3.png"))); // NOI18N
        jLabel1.setText("Register now");
        jLabel1.setName("Register now"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jButton1.setText("Register now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logButtonMouseClicked
        String id = txtuname.getText();
        char[] pwd = txtpwd.getPassword();
        
        String pw = new String(pwd);
        
        Session session = ControllerPck.Controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From User";
        Query query = session.createQuery(sql);
        
        List<User> users = query.list();
        
        //ierate data from row to row
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User next = iterator.next();
            
            if (next.getUserId().equalsIgnoreCase(id) && next.getPassword().equals(pw)) {
                if (next.getUserId().startsWith("adm")) {
                    AdminDashboard adminDashboard = new AdminDashboard(uid);
                    this.setUid(id);
                    adminDashboard.setVisible(true);
                    this.dispose();
                }
                else{
                    this.setUid(id);
                    UserDashboard userDashboard = new UserDashboard(uid);
                    userDashboard.setUid(uid);
                    System.out.println("login"+uid);
                    userDashboard.setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_logButtonMouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x = evt.getXOnScreen() - xmouse;
        int y = evt.getYOnScreen() - ymouse;
        this.setLocation(x, y);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunameActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logButton;
    private javax.swing.JPasswordField txtpwd;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}

