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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Server extends javax.swing.JFrame {
    
    public static ServerSocket sSoket;
    public static Socket soket;
    public static DataInputStream veriAl;
    public static DataOutputStream VeriYolla;

    public Server() {
        int port;
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        port_field = new javax.swing.JTextField();
        server_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesajlar = new javax.swing.JTextArea();
        mesaj_alani = new javax.swing.JTextField();
        mesaj_butonu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setText("Dinlenecek port numarası");

        port_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                port_fieldActionPerformed(evt);
            }
        });

        server_btn.setBackground(new java.awt.Color(0, 153, 255));
        server_btn.setText("server'i baslat");
        server_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_btnActionPerformed(evt);
            }
        });

        mesajlar.setColumns(20);
        mesajlar.setRows(5);
        jScrollPane1.setViewportView(mesajlar);

        mesaj_butonu.setBackground(new java.awt.Color(0, 153, 255));
        mesaj_butonu.setText("gonder");
        mesaj_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaj_butonuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(port_field, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(server_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesaj_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(port_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(server_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaj_alani, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(mesaj_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesaj_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaj_butonuActionPerformed
      // Mesajı al ve anahtarı belirle
      String mesaj = mesaj_alani.getText();
      int anahtar = 4;

      // Mesajı şifrele
      StringBuilder sb = new StringBuilder();
      
      //tarih ekleme
        Date zaman = new Date();
      
      for (int i = 0; i < mesaj.length(); i++) {
        char c = (char)(mesaj.charAt(i) + anahtar);
        sb.append(c);
        }
        
      String sifreliMesaj = sb.toString();

      try {
        // Şifreli mesajı gönder
        VeriYolla.writeUTF(sifreliMesaj);
        }catch (IOException ex) {
          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {  
          String msgout = "";  
          msgout = mesaj_alani.getText().trim();  
          VeriYolla.writeUTF(msgout);  
        }catch (Exception e) {}
       try {
        // log.txt dosyasının yolunu belirtin
        FileWriter fileWriter = new FileWriter("logging.txt");
        // Dosyaya yazma işlemi için BufferedWriter nesnesi oluşturun
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
        // mesajlar değişkenindeki verileri dosyaya yazın
        //bufferedWriter.write(zaman.toString()); -> aktif ettiğimizde sadece zamanı ekliyor mesajlar gelmiyor onu çözemedik
        bufferedWriter.write(mesajlar.getText());
        
        // Dosyaya yazma işlemi
        bufferedWriter.close();
        //bufferedWriter2.close();
        } catch (IOException ex) {
        // Hata durumunda log dosyası oluşturulamadığını gösteren mesaj gösterin
        JOptionPane.showMessageDialog(null, "Log dosyası oluşturulamadı!");
        }
    }//GEN-LAST:event_mesaj_butonuActionPerformed
   
    private void server_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_btnActionPerformed
  
    }//GEN-LAST:event_server_btnActionPerformed

    private void port_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_fieldActionPerformed
        
    }//GEN-LAST:event_port_fieldActionPerformed
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          try {
            String msgout = "";
            msgout = mesaj_alani.getText().trim();
            VeriYolla.writeUTF(msgout);
            mesajlar.append("Server : " + msgout);
            mesaj_alani.setText(" ");
            }catch (Exception f) {
              System.out.println(f);
           }
        }
    }
  
    public static void main(String args[]) {  java.awt.EventQueue.invokeLater(new Runnable() {  
      public void run() {  
        new Server().setVisible(true); }});  
          
        String msgin = ""; 
        
        
        
        try {  
            
          sSoket = new ServerSocket(1201);  
          soket = sSoket.accept();  
          veriAl = new DataInputStream(soket.getInputStream());  
          VeriYolla = new DataOutputStream(soket.getOutputStream());  
          
        while (!msgin.equals("exit")) {  
        msgin = veriAl.readUTF();  
        mesajlar.setText(mesajlar.getText().trim() + "\n Client:" + msgin);  
        }  
        }catch (Exception e) {}  
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mesaj_alani;
    private javax.swing.JButton mesaj_butonu;
    private static javax.swing.JTextArea mesajlar;
    private javax.swing.JTextField port_field;
    private javax.swing.JButton server_btn;
    // End of variables declaration//GEN-END:variables
}
