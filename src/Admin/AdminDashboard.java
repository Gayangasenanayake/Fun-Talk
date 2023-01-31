package Admin;

import User.*;
import ControllerPck.Controller;
import Login.Login;
import Pojo.Chat;
import Pojo.Chatsubscribers;
import Subscriber.Observable;
import Subscriber.Observer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDashboard extends javax.swing.JFrame{

    int xmouse;
    int ymouse;
    int height = 10;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String id) {
        this.uid = id;
        System.out.println("dashboard"+uid);
    }

    public AdminDashboard() {
        initComponents();
        
        jPanel3.removeAll();
        jPanel3.revalidate();
        jPanel3.repaint();
        height = 10;
        this.createBuble();
    }
    
    public AdminDashboard(String uid) {
        this.uid = uid;
        initComponents();
        
        jPanel3.removeAll();
        jPanel3.revalidate();
        jPanel3.repaint();
        height = 10;
        this.createBuble();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Chat List");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 100, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel3);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 460));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 940, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/icons8_close_window_25px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/icons8_plus_50px_1.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/detailsBack.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int x = evt.getXOnScreen() - xmouse;
        int y = evt.getYOnScreen() - ymouse;
        this.setLocation(x, y);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        JFrame frame = new JFrame();
        String chatName = JOptionPane.showInputDialog(frame, "Enter New Chat Name:");
        createNewChat(chatName);
        
        jPanel3.removeAll();
        jPanel3.revalidate();
        jPanel3.repaint();
        height = 10;
        createBuble();
    }//GEN-LAST:event_jLabel5MouseClicked

    void createBuble() {
        String status = null;
        Session session = Controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();//

        String sql = "From Chat";
        Query query = session.createQuery(sql);

        List<Chat> chatList = query.list();

        for (Iterator<Chat> iterator = chatList.iterator(); iterator.hasNext();) {
            Chat next = iterator.next();

            String chatId = next.getChatId();
            String subscribedChatId = null;
            String chatName = next.getName();
            Date chatDateCreated = next.getDateCreated();
            int members = 0;

            JPanel jPanel4 = new JPanel();
            JLabel lblSubscribeToggle = new JLabel();
            JLabel jLabel11 = new JLabel();
            JLabel jLabel9 = new JLabel();
            JLabel jLabel10 = new JLabel();
            JLabel lblMemberCount = new JLabel();
            JLabel lblDateCreated = new JLabel();
            JLabel jLabel6 = new JLabel();
            JLabel lblChatId = new JLabel();
            JLabel lblChatName = new JLabel();
            JLabel jLabel5 = new JLabel();

            jPanel4.setBackground(new java.awt.Color(204, 204, 204));
            jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lblSubscribeToggle.setBackground(new java.awt.Color(0, 102, 102));
            lblSubscribeToggle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblSubscribeToggle.setForeground(new java.awt.Color(255, 255, 255));
            lblSubscribeToggle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            Session session1 = Controller.getSessionFactory().openSession();
            Transaction transaction1 = session1.beginTransaction();

            String sql1 = "From Chatsubscribers";
            Query q1 = session1.createQuery(sql1);

            List<Chatsubscribers> subscribersList = q1.list();

            for (Iterator<Chatsubscribers> iterator1 = subscribersList.iterator(); iterator1.hasNext();) {
                Chatsubscribers next1 = iterator1.next();

                if (chatId.equals(next1.getChatId())) {
                    members = members + 1;
                }
            }
            
            lblSubscribeToggle.setText("Delete");
            
            System.out.println(chatId + "\t" + chatName + "\t" + chatDateCreated + "\t" + members);

            lblSubscribeToggle.setOpaque(true);
            jPanel4.add(lblSubscribeToggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 14, 150, 32));

            jLabel11.setFont(new java.awt.Font("Segoe Print", 0, 48)); // NOI18N
            jLabel11.setForeground(new java.awt.Color(0, 102, 102));
            jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel11.setText("|");
            jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, 40));

            jLabel10.setFont(new java.awt.Font("Segoe Print", 0, 48)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(0, 102, 102));
            jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel10.setText("|");
            jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 40));

            jLabel9.setFont(new java.awt.Font("Segoe Print", 0, 48)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(0, 102, 102));
            jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel9.setText("|");
            jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 40));

            lblMemberCount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblMemberCount.setForeground(new java.awt.Color(255, 255, 255));
            lblMemberCount.setText(String.valueOf(members));
            lblMemberCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel4.add(lblMemberCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 60, 40));

            lblDateCreated.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblDateCreated.setForeground(new java.awt.Color(255, 255, 255));
            lblDateCreated.setText(String.valueOf(chatDateCreated));
            lblDateCreated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel4.add(lblDateCreated, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 40));

            jLabel6.setFont(new java.awt.Font("Segoe Print", 0, 48)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(0, 102, 102));
            jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel6.setText("|");
            jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, 40));

            lblChatId.setBackground(new java.awt.Color(0, 153, 153));
            lblChatId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblChatId.setForeground(new java.awt.Color(255, 255, 255));
            lblChatId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblChatId.setText(chatId);
            lblChatId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblChatId.setOpaque(true);
            jPanel4.add(lblChatId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

            lblChatName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblChatName.setForeground(new java.awt.Color(255, 255, 255));
            lblChatName.setText(chatName);
            lblChatName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel4.add(lblChatName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 380, 40));

            jLabel5.setBackground(new java.awt.Color(0, 153, 153));
            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setOpaque(true);
            jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 40));

            getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 920, 60));

            jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, height, 920, 60));
            height = height + 70;

            jPanel4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Chat id in dash: "+chatId);
                    ChatDetails chatDetails = new ChatDetails(uid, chatId);
                    chatDetails.setVisible(true);
                    disposeAdmin();
                }
            });
            
            lblSubscribeToggle.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    deleteChat(chatId);
                }
            });

        }

    }
    
    public void disposeAdmin()
    {
        this.dispose();
    }
    
    public void deleteChat(String chatId)
    {
        Session sUn = Controller.getSessionFactory().openSession();
        Transaction tUn = sUn.beginTransaction();

        Chat ct = (Chat) sUn.load(Chat.class, chatId);
        
        sUn.delete(ct);
        tUn.commit();
        
        jPanel3.removeAll();
        jPanel3.revalidate();
        jPanel3.repaint();
        height = 10;
        createBuble();
    }
    
    public void createNewChat(String chatName)
    {
        int count = 0;
        String finalChat = null;

        Session cnew = Controller.getSessionFactory().openSession();
        Transaction tnew = cnew.beginTransaction();
        
        String csql = "From Chat";
        Query cq = cnew.createQuery(csql);
        
        List<Chat> chatList = cq.list();
        
        for (Iterator<Chat> iterator = chatList.iterator(); iterator.hasNext();) {
            Chat next = iterator.next();
            count = count+1;
            finalChat = next.getChatId();
        }
        
        cnew.close();
        
        String c = String.valueOf(count);
        String chatId = "cht0"+c;
        Date date=java.util.Calendar.getInstance().getTime();
        
        Session schat = Controller.getSessionFactory().openSession();
        Transaction tchat = schat.beginTransaction();
        
        Chat chat = new Chat();
        
        chat.setChatId(chatId);
        chat.setName(chatName);
        chat.setDateCreated(date);
        
        schat.save(chat);
        tchat.commit();
        schat.close();       
        
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}