package User;

import ControllerPck.Controller;
import DnetMessage.Message;
import Login.Login;
import Pojo.Chat;
import Pojo.Student;
import Pojo.User;
import Services.Talk;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChatBox extends javax.swing.JFrame {

    Registry reg;
    Talk chat;
    private String userId;
    int height = 10;
    ImageIcon x;
    int xmouse;
    int ymouse;
    UserDashboard ud;
//    private String chatId;

    public ChatBox() {
        initComponents();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        this.load_client();
    }

//    public String getChatId() {
//        return chatId;
//    }
//
//    public void setChatId(String chatId) {
//        this.chatId = chatId;
//    }
    public String getUserId() {
        return userId;
    }
    public void setUserDashboard(UserDashboard ud) {
        this.ud = ud;
    }

    public void setUserId(String userId) {
        this.userId = userId;
//        System.out.println("chat"+userId);
    }

//
    public void load_client() {
        try {
            reg = LocateRegistry.getRegistry("localhost", 1997);
            chat = (Talk) reg.lookup("DNETAdmin");
            retrivemsg.start();
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex);
        }
    }

    Thread retrivemsg = new Thread() {
        public void run() {

            int preiv = 0;

            while (true) {
                try {

                    Message nmsg = chat.broadcast();
                    if (nmsg != null) {
                        if (preiv != nmsg.getMsgid()) {
                            System.out.println("in the thread line number 76");
                            System.out.println(nmsg.getDate_time() + "\t" + nmsg.getName() + " : " + nmsg.getMessage() + "\n");
                            createBuble(nmsg.getAvatar(), nmsg.getMessage(), nmsg.getName(), nmsg.getDate_time());
                            preiv = nmsg.getMsgid();
                        }
                    }

                    Thread.sleep(100);
                } catch (RemoteException | NullPointerException ex) {
                    System.out.println(ex);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    };

    void createBuble(Icon avatar, String text, String id, String time) {

        JPanel jPanel5 = new javax.swing.JPanel();
        JLabel lblAvatarName = new javax.swing.JLabel();
        JLabel lblAvatar = new javax.swing.JLabel();
        JLabel lblMessage = new javax.swing.JLabel();
        int rows = txtContect.getRows();
        lblAvatarName.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatarName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        lblAvatarName.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        Session session = ControllerPck.Controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "From Student";
        Query query = session.createQuery(sql);
        String name = null;

        List<Student> students = query.list();

        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student next = iterator.next();

            if (id.equalsIgnoreCase(next.getId())) {
                name = next.getName();
            }
        }

        if (userId.equals(id)) {
            jPanel5.setBackground(new java.awt.Color(153, 153, 153));
            jPanel5.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 40, 40));
            jPanel5.add(lblAvatarName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 5, 650, 15));
            lblAvatarName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            lblAvatarName.setText(time + "      " + name);
            jPanel5.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 25, 650, 30));
            lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        } else {
            jPanel5.setBackground(new java.awt.Color(0, 153, 153));
            jPanel5.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));
            jPanel5.add(lblAvatarName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 5, 650, 15));
            lblAvatarName.setText(name + "      " + time);
            jPanel5.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 25, 650, 30));
        }

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, height, 790, 60));
        height = height + 70;
        lblAvatar.setIcon(resizeImg((ImageIcon) avatar));

        lblMessage.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));

        lblMessage.setText(text);

        JScrollBar jbar = jScrollPane2.getVerticalScrollBar();
        jbar.setValue(jbar.getMaximum());
    }

    public ImageIcon resizeImg(ImageIcon avatarImage) {
        //  ImageIcon avatarImage = new ImageIcon(image);
        Image img = avatarImage.getImage();
        Image newImage = img.getScaledInstance(40, 40, img.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(newImage);
        return scaledImage;
    }

    public ImageIcon resize(String path) {
        ImageIcon avatarImage = new ImageIcon(path);
        Image img = avatarImage.getImage();
        Image newImage = img.getScaledInstance(40, 40, img.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(newImage);
        return scaledImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContect = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel2.setText("WE Chat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 460, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(jPanel4);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 340));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        txtContect.setColumns(20);
        txtContect.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        txtContect.setLineWrap(true);
        txtContect.setRows(1);
        txtContect.setWrapStyleWord(true);
        txtContect.setBorder(null);
        jScrollPane1.setViewportView(txtContect);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/icons8_email_send_50px_1.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/icons8_close_window_25px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/user_chat.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setChat(String nameReceieved) {
        System.out.println(nameReceieved);
        jLabel2.setText(nameReceieved);
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (txtContect.getText().equals("")) {
            System.out.println("lbl3 clicked");
        } else {
            try {
                Session session = Controller.getSessionFactory().openSession();
                //Transaction transaction = session.beginTransaction();
                Student student = (Student) session.load(Student.class, userId);

                ByteArrayInputStream bis = new ByteArrayInputStream(student.getAvatar());
                BufferedImage bImage2 = ImageIO.read(bis);

                x = new ImageIcon(bImage2);

            } catch (Exception e) {
                Logger.getLogger(ChatBox.class.getName()).log(Level.SEVERE, null, e);
            }

            String client_m = txtContect.getText();
            String client_n = userId;

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time_now = myDateObj.format(myFormatObj);

            Message msg = new Message();
            msg.setMsgid(msg.hashCode());
            msg.setName(client_n);
            msg.setMessage(client_m);
            msg.setDate_time(time_now);
            msg.setAvatar(x);

            try {
                chat.send_message(msg);

            } catch (RemoteException ex) {
                System.out.println("Error line 283 " + ex);
            } catch (Exception ex) {
                System.out.println("error line 285 catch " + ex.getMessage());
            }

            txtContect.setText("");
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        int x = evt.getXOnScreen() - xmouse;
        int y = evt.getYOnScreen() - ymouse;
        this.setLocation(x, y);
    }//GEN-LAST:event_jLabel4MouseDragged

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtContect;
    // End of variables declaration//GEN-END:variables
}
