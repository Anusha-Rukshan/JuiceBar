/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddItem.java
 *
 * Created on May 20, 2018, 7:39:50 PM
 */
package orangefruit;


import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Kushiya
 */
public class AddItem extends javax.swing.JFrame {

    DB db = new DB();
    /** Creates new form AddItem */
    public AddItem() {
        initComponents();
        auto_id();
    }
    
    void auto_id() {
        int num = 0;
        try {
            ResultSet r = db.getdata("select * from items order by itemID");
            while (r.next()) {
                num = Integer.parseInt(r.getString("itemID"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        int id = num + 1;
        lbl_itemID.setText("000" + id + "");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_itemName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_itemID = new javax.swing.JLabel();
        btn_addItem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Item");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Item ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 106, -1, -1));
        getContentPane().add(txt_itemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 141, -1, -1));
        getContentPane().add(lbl_itemID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn_addItem.setText("Add");
        btn_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 230, 71, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Buttons/280add.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 400, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void btn_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addItemActionPerformed
    if(txt_itemName.getText().isEmpty())
        JOptionPane.showMessageDialog(null, "Enter Item Name!");
    else
        {
            try {
                db.putdata("insert into items values ('" + lbl_itemID.getText() + "', '" + txt_itemName.getText() + "')");
                JOptionPane.showMessageDialog(null, "Added!");
                this.dispose();
                new AddItem().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}//GEN-LAST:event_btn_addItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_itemID;
    private javax.swing.JTextField txt_itemName;
    // End of variables declaration//GEN-END:variables
}