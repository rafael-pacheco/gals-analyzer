package br.furb.view;

import br.furb.controller.AnalyzeEntry;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    AnalyzeEntry analyze = new AnalyzeEntry();

    public Main() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTSaida = new javax.swing.JTextArea();
        JBEquipe = new javax.swing.JButton();
        JBAnalisar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEntrada = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secretaria da Receita Federal");
        setResizable(false);

        JTSaida.setEditable(false);
        JTSaida.setColumns(20);
        JTSaida.setRows(5);
        jScrollPane2.setViewportView(JTSaida);

        JBEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/images/Equipe.png"))); // NOI18N
        JBEquipe.setText("Equipe");
        JBEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEquipeActionPerformed(evt);
            }
        });

        JBAnalisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/images/Analisar.png"))); // NOI18N
        JBAnalisar.setText("Analisar");
        JBAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAnalisarActionPerformed(evt);
            }
        });

        JBLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/images/Limpar.png"))); // NOI18N
        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JTEntrada.setBorder(new NumberedBorder());
        JTEntrada.setColumns(200);
        JTEntrada.setRows(999);
        jScrollPane1.setViewportView(JTEntrada);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JBAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(JBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(JBEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEquipeActionPerformed
        JTSaida.setText("Equipe: Rafael de Moura Pacheco, Rodrigo Fernandes");
    }//GEN-LAST:event_JBEquipeActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        JTEntrada.setText("");
        this.analyze.clearContent();
        JTSaida.setText("");
    }//GEN-LAST:event_JBLimparActionPerformed

    private void JBAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAnalisarActionPerformed
        if (JTEntrada.getText().equals("") || JTEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Atenção!!\n"
                    + "Nenhuma expressão encontrada!");
        } else {
            this.analyze.validateInput(JTEntrada.getText());
            JTSaida.setText(this.analyze.getOutput());
        }
        
    }//GEN-LAST:event_JBAnalisarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAnalisar;
    private javax.swing.JButton JBEquipe;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JTextArea JTEntrada;
    private javax.swing.JTextArea JTSaida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
