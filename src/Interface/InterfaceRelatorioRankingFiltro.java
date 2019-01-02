package Interface;

import Classes.Emprestimo;
import Classes.Livro;
import Util.Functions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceRelatorioRankingFiltro extends javax.swing.JDialog {

    public InterfaceRelatorioRankingFiltro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModal(true);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTRelatorioRankingLivros = new javax.swing.JTable();
        btnGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RELATÓRIO RAKING DE LIVROS(TOP 10)");

        jTRelatorioRankingLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POSIÇÃO", "CÓDIGO", "TÍTULO", "AUTOR", "GÊNERO", "EDIÇÃO", "QTD.EXEMPLARES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jTRelatorioRankingLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTRelatorioRankingLivrosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTRelatorioRankingLivros);
        if (jTRelatorioRankingLivros.getColumnModel().getColumnCount() > 0) {
            jTRelatorioRankingLivros.getColumnModel().getColumn(0).setMaxWidth(66);
            jTRelatorioRankingLivros.getColumnModel().getColumn(1).setMaxWidth(59);
        }

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerar.png"))); // NOI18N
        btnGerar.setText("GERAR RELATÓRIO");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("RELATÓRIO RANKING(TOP 10) DOS LIVROS COM MAIS EMPRÉSTIMO REGISTRADO ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PERÍODO EMPRÉSTIMO"));

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicial.setToolTipText("");
        txtDataInicial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDataInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataInicialFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("DATA INICIAL*");

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFinal.setToolTipText("");
        txtDataFinal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDataFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataFinalFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("DATA FINAL*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(5, 5, 5)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGerar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTRelatorioRankingLivrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRelatorioRankingLivrosMouseReleased

    }//GEN-LAST:event_jTRelatorioRankingLivrosMouseReleased

    public boolean validaCampos() {
        if (txtDataInicial.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA INICIAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (txtDataFinal.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA FINAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataInicial.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA VÁLIDA PARA O PERÍODO INICIAL!", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataFinal.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA VÁLIDA PARA O PERÍODO FINAL!", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (Functions.dataMenorQueHoje(txtDataInicial.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA INICIAL NÃO PODE SER POSTERIOR À DATA DE ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (Functions.dataMenorQueHoje(txtDataFinal.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA FINAL NÃO PODE SER POSTERIOR À DATA DE ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (LocalDate.parse(txtDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(
                LocalDate.parse(txtDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
            JOptionPane.showMessageDialog(null, "DATA DO PERÍODO FINAL DEVE SER MAIOR OU IGUAL A DATA DO PERÍODO INICIAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        }
        return true;
    }

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed

        DefaultTableModel dtmRelRankingLivros = (DefaultTableModel) jTRelatorioRankingLivros.getModel();

        if (validaCampos() == false) {

        } else {
            LocalDate dataInicial = LocalDate.parse(txtDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).minusDays(1);
            LocalDate dataFinal = LocalDate.parse(txtDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1);
            List<Emprestimo> emprestimosPeriodo = new ArrayList<>();
            dtmRelRankingLivros.setRowCount(0);

            for (int i = 0; i < Livro.listaLivros.size(); i++) {
                Emprestimo emprestimoEntrePeriodo = Emprestimo.emprestimoLivroPeriodo(Livro.listaLivros.get(i), dataInicial, dataFinal);
                if (emprestimoEntrePeriodo != null) {
                    emprestimosPeriodo.add(emprestimoEntrePeriodo);
                }
            }

            if (emprestimosPeriodo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NÃO HÁ REGISTROS DE EMPRÉSTIMOS MO PERÍODO INFORMADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                txtDataInicial.grabFocus();
            } else {
                Collections.sort(emprestimosPeriodo, new Comparator<Emprestimo>() {
                    @Override
                    public int compare(Emprestimo l1, Emprestimo l2) {
                        Livro livro1 = Livro.buscarLivro(l1.getLivro().getCodigo());
                        Livro livro2 = Livro.buscarLivro(l2.getLivro().getCodigo());
                        return livro2.getQtdEmprestimoPeriodo() - livro1.getQtdEmprestimoPeriodo();
                    }
                });
                int cont = 0;
                for (Emprestimo emprestimo : emprestimosPeriodo) {
                    Livro livro = Livro.buscarLivro(emprestimo.getLivro().getCodigo());
                    if (cont < 10) {
                        cont++;
                        String posicao = "";
                        dtmRelRankingLivros.addRow(new Object[]{
                            posicao = String.valueOf(cont) + " ª",
                            livro.getCodigo(),
                            livro.getTitulo(),
                            livro.getAutor().getNomeAutor(),
                            livro.getGenero().getNomeGenero(),
                            livro.getEdicao(),
                            livro.getQtdEmprestimoPeriodo()
                        });
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    private void txtDataInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataInicialFocusLost
        txtDataInicial.setFocusLostBehavior(JFormattedTextField.COMMIT);
    }//GEN-LAST:event_txtDataInicialFocusLost

    private void txtDataFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFinalFocusLost
        txtDataFinal.setFocusLostBehavior(JFormattedTextField.COMMIT);
    }//GEN-LAST:event_txtDataFinalFocusLost

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
            java.util.logging.Logger.getLogger(InterfaceRelatorioRankingFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRankingFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRankingFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioRankingFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceRelatorioRankingFiltro dialog = new InterfaceRelatorioRankingFiltro(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTRelatorioRankingLivros;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables
}
