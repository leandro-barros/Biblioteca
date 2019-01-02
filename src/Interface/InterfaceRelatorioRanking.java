package Interface;

import Classes.Aluno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceRelatorioRanking extends javax.swing.JDialog {
    
    public boolean alterar;
    
    public InterfaceRelatorioRanking(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModal(true);
        setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTRelatorioAlunos = new javax.swing.JTable();
        btnGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RELATÓRIO RAKING DE ALUNOS(TOP 10)");

        jTRelatorioAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POSIÇÃO", "CÓDIGO", "NOME", "CPF", "MATRÍCULA", "QTD.EMPRÉSTIMOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTRelatorioAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTRelatorioAlunosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTRelatorioAlunos);
        if (jTRelatorioAlunos.getColumnModel().getColumnCount() > 0) {
            jTRelatorioAlunos.getColumnModel().getColumn(0).setMaxWidth(66);
            jTRelatorioAlunos.getColumnModel().getColumn(1).setMaxWidth(59);
            jTRelatorioAlunos.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerar.png"))); // NOI18N
        btnGerar.setText("GERAR RELATÓRIO");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("RELATÓRIO RANKING(TOP 10) DOS ALUNOS COM MAIS EMPRÉSTIMO REGISTRADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(btnGerar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTRelatorioAlunosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRelatorioAlunosMouseReleased

    }//GEN-LAST:event_jTRelatorioAlunosMouseReleased

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        
        Aluno a = new Aluno();
        DefaultTableModel dtmRelatorioRankingAlunos = (DefaultTableModel) jTRelatorioAlunos.getModel();
        dtmRelatorioRankingAlunos.setRowCount(0);
        
        if (Aluno.listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUM ALUNO CADASTRADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            List<Aluno> alunosRanking = new ArrayList<>();
            int cont = 0;
            Collections.sort(Aluno.listaAlunos, Comparator.comparing(Aluno::getQuantidadeEmprestimo).reversed());
            for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
                if (Aluno.listaAlunos.get(i).getQuantidadeEmprestimo() > 0) {
                    if (cont < 10) {
                        alunosRanking.add(Aluno.listaAlunos.get(i));
                        cont++;
                    }
                }
            }
            
            if (alunosRanking.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NENHUM ALUNO ENCONTRADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                String posicao = "";
                for (int i = 0; i < cont; i++) {
                    dtmRelatorioRankingAlunos.addRow(new Object[]{
                        posicao = String.valueOf(i + 1) + " ª",
                        alunosRanking.get(i).getCodigo(),
                        alunosRanking.get(i).getNome(),
                        alunosRanking.get(i).getCpf(),
                        alunosRanking.get(i).getMatricula(),
                        alunosRanking.get(i).getQuantidadeEmprestimo()
                    });
                }
                
            }
        }
    }//GEN-LAST:event_btnGerarActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceRelatorioRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceRelatorioRanking dialog = new InterfaceRelatorioRanking(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTRelatorioAlunos;
    // End of variables declaration//GEN-END:variables
}
