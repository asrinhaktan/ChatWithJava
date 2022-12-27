/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chatprojesi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author asrinhaktansahin
 */
public class Client extends javax.swing.JFrame {
    public static Socket soket;
    public static DataInputStream veriAl;
    public static DataOutputStream veriYolla;
   
    public Client() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sip = new javax.swing.JTextField();
        baglan_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesajlar = new javax.swing.JTextArea();
        mesaj_alani = new javax.swing.JTextField();
        mesaj_butonu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Server IP");

        sip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipActionPerformed(evt);
            }
        });

        baglan_btn.setBackground(new java.awt.Color(0, 153, 255));
        baglan_btn.setText("Baglan");
        baglan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baglan_btnActionPerformed(evt);
            }
        });

        mesajlar.setColumns(20);
        mesajlar.setRows(5);
        jScrollPane1.setViewportView(mesajlar);

        mesaj_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaj_alaniActionPerformed(evt);
            }
        });

        mesaj_butonu.setBackground(new java.awt.Color(0, 153, 255));
        mesaj_butonu.setText("gonder");
        mesaj_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaj_butonuActionPerformed(evt);
            }
        });

        jLabel2.setText("Port");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(baglan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesaj_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baglan_btn)
                    .addComponent(jLabel2)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaj_alani, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(mesaj_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baglan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baglan_btnActionPerformed
     try {  
        String msgout = "";  
        msgout = mesaj_alani.getText().trim();  
        veriYolla.writeUTF(msgout);  
    } catch (Exception e) {}  
     
    }//GEN-LAST:event_baglan_btnActionPerformed

    private void mesaj_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaj_butonuActionPerformed
    // Mesajı al ve anahtarı belirle
    String mesaj = mesaj_alani.getText();
    int anahtar = 4;
    
    //Zaman ekleme
    Date zaman = new Date();

    // Mesajı şifrele
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < mesaj.length(); i++) {
        char c = (char)(mesaj.charAt(i) + anahtar);
        sb.append(c);
    }
    String sifreliMesaj = sb.toString();

    // Şifreli mesajı server'a gönderme
    try {
        veriYolla.writeUTF(sifreliMesaj);
    } catch (Exception e) {
        System.out.println("hata");
    }
    
        try{
            String msgout = "";
            msgout = mesaj_alani.getText().trim();
            veriYolla.writeUTF(msgout);
            mesajlar.append("Client : "+msgout+"\n");
            mesaj_alani.setText(" ");
        }catch(Exception e){
            System.out.println(e);
        }
        try {
    // log.txt dosyasının yolunu belirtin
        FileWriter fileWriter = new FileWriter("logging.txt");
    // Dosyaya yazma işlemi için BufferedWriter nesnesi oluşturun
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
    // mesajlar değişkenindeki verileri dosyaya yazın
        bufferedWriter.write(zaman.toString());
        bufferedWriter2.write(mesajlar.getText());
    // Dosyaya yazma işlemini tamamlayın
        bufferedWriter.close();
        bufferedWriter2.close();
} catch (IOException ex) {
    // Hata durumunda log dosyası oluşturulamadığını gösteren mesaj gösterin
    JOptionPane.showMessageDialog(null, "Log dosyası oluşturulamadı!");
}
    }//GEN-LAST:event_mesaj_butonuActionPerformed

    private void sipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipActionPerformed

    private void mesaj_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaj_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaj_alaniActionPerformed

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            try {
                String msgout = "";
                msgout = mesaj_alani.getText().trim();
                veriYolla.writeUTF(msgout);
                mesajlar.append("Server : " + msgout);
                mesaj_alani.setText(" ");
                
            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public void keyReleased(KeyEvent e) {}
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                new Client().setVisible(true);  
                              }  
                              });  
            try {  
                soket = new Socket("127.0.0.1", 1201);  
                veriAl = new DataInputStream(soket.getInputStream());  
                veriYolla = new DataOutputStream(soket.getOutputStream());  
                String msgin = "";  
                while (!msgin.equals("Exit")) {  
                    msgin = veriAl.readUTF();  
                    mesajlar.setText(mesajlar.getText().trim() + "\n Server:" + msgin+"\n");  
                                                          }  
            }catch (Exception e) {}  
 }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baglan_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mesaj_alani;
    private javax.swing.JButton mesaj_butonu;
    private static javax.swing.JTextArea mesajlar;
    private javax.swing.JTextField port;
    private javax.swing.JTextField sip;
    // End of variables declaration//GEN-END:variables
}
