package Interface;

import Classes.Aluno;
import Classes.Genero;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceRelatorioAlunos extends javax.swing.JDialog {

    public boolean alterar;

    public InterfaceRelatorioAlunos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModal(true);
        setResizable(false);
    }

    public void listarGeneros() {
        DefaultTableModel dtm = (DefaultTableModel) jTRelatorioAlunos.getModel();
        for (int i = 0; i < Genero.listaGeneros.size(); i++) {
            dtm.addRow(new Object[]{
                Genero.listaGeneros.get(i).getCodigo(),
                Genero.listaGeneros.get(i).getNomeGenero()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTRelatorioAlunos = new javax.swing.JTable();
        btnGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RELATÓRIO GERAL DOS ALUNOS");

        jTRelatorioAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "CPF", "MATRÍCULA", "EMAIL", "TELEFONE", "DATA NASCIMENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTRelatorioAlunos.getColumnModel().getColumn(0).setMaxWidth(69);
        }

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerar.png"))); // NOI18N
        btnGerar.setText("GERAR RELATÓRIO");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("RELATÓRIO GERAL DE TODOS OS ALUNOS CADASTRADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(btnGerar)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTRelatorioAlunosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRelatorioAlunosMouseReleased

    }//GEN-LAST:event_jTRelatorioAlunosMouseReleased

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed

        DefaultTableModel dtmRelatorioAlunos = (DefaultTableModel) jTRelatorioAlunos.getModel();
        dtmRelatorioAlunos.setNumRows(0);
        if (Aluno.listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUM ALUNO CADASTRADO !", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Collections.sort(Aluno.listaAlunos, Comparator.comparing(Aluno::getNome));
            for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
                dtmRelatorioAlunos.addRow(new Object[]{
                    Aluno.listaAlunos.get(i).getCodigo(),
                    Aluno.listaAlunos.get(i).getNome(),
                    Aluno.listaAlunos.get(i).getCpf(),
                    Aluno.listaAlunos.get(i).getMatricula(),
                    Aluno.listaAlunos.get(i).getEmail(),
                    Aluno.listaAlunos.get(i).getTelefone(),
                    Aluno.listaAlunos.get(i).getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),});
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
            java.util.logging.Logger.getLogger(InterfaceRelatorioAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceRelatorioAlunos dialog = new InterfaceRelatorioAlunos(new javax.swing.JFrame(), true);
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
