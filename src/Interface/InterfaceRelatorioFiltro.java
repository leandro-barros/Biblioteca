package Interface;

import Classes.Emprestimo;
import Classes.Genero;
import Util.Functions;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceRelatorioFiltro extends javax.swing.JDialog {

    public InterfaceRelatorioFiltro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        coloreTable();
        setModal(true);
        setResizable(false);

        for (int i = 0; i < Genero.listaGeneros.size(); i++) {
            jCGenero.addItem(Genero.listaGeneros.get(i).getNomeGenero());
        }
    }

    public void coloreTable() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String str = (String) value;

                if ("DEVOLVIDO".equals(str)) {
                    c.setForeground(Color.GREEN);
                } else if ("EMPRESTADO".equals(str)) {
                    c.setForeground(Color.orange);
                } else if ("RENOVADO".equals(str)) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        };
        jTRelEmprestimo.getColumnModel().getColumn(5).setCellRenderer(renderer);
    }

    public boolean validaCampos() {
        if (txtDataInicial.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA INICIAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (txtDataFinal.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA FINAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataFinal.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA VÁLIDA PARA O PERÍODO INICIAL!", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataInicial.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA VÁLIDA PARA O PERÍODO FINAL!", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (Functions.dataMenorQueHoje(txtDataFinal.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA FINAL NÃO PODE SER POSTERIOR À DATA DE ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        } else if (Functions.dataMenorQueHoje(txtDataInicial.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA INICIAL NÃO PODE SER POSTERIOR À DATA DE ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataInicial.grabFocus();
            return false;
        } else if (LocalDate.parse(txtDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(
                LocalDate.parse(txtDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
            JOptionPane.showMessageDialog(null, "DATA DO PERÍODO FINAL DEVE SER MAIOR OU IGUAL A DATA DO PERÍODO INICIAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataFinal.grabFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRelEmprestimo = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jCGenero = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RELATÓRIO DE EMPRÉSTIMOS");

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerar.png"))); // NOI18N
        btnGerar.setText("GERAR RELATÓRIO");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("RELATÓRIO DE EMPRÉSTIMOS POR DATA E GÊNERO ");

        jTRelEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "COD.ALUNO", "ALUNO", "LIVRO", "DATA EMPRÉSTIMO", "SITUAÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTRelEmprestimo);
        if (jTRelEmprestimo.getColumnModel().getColumnCount() > 0) {
            jTRelEmprestimo.getColumnModel().getColumn(0).setMaxWidth(59);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("GÊNERO*");

        jCGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PERÍODO EMPRÉSTIMO"));

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("DATA INICIAL*");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("DATA FINAL*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
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
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jCGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(btnGerar)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addGap(5, 5, 5)
                        .addComponent(jCGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        DefaultTableModel dtmRelEmprestimo = (DefaultTableModel) jTRelEmprestimo.getModel();
        if (validaCampos() == false) {

        } else {
            LocalDate dataInicial = LocalDate.parse(txtDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).minusDays(1);
            LocalDate dataFinal = LocalDate.parse(txtDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1);
            if (Emprestimo.listaEmprestimos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NENHUM EMPRÉSTIMO REGISTRADO !", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dtmRelEmprestimo.setNumRows(0);
                List<Emprestimo> emprestimosFiltrados = new ArrayList<>();
                for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
                    if (jCGenero.getSelectedIndex() == 0) {
                        if (Emprestimo.listaEmprestimos.get(i).getDataEmprestimo().isAfter(dataInicial)
                                && Emprestimo.listaEmprestimos.get(i).getDataEmprestimo().isBefore(dataFinal)) {
                            emprestimosFiltrados.add(Emprestimo.listaEmprestimos.get(i));
                        }
                    } else {
                        if (Emprestimo.listaEmprestimos.get(i).getDataEmprestimo().isAfter(dataInicial)
                                && Emprestimo.listaEmprestimos.get(i).getDataEmprestimo().isBefore(dataFinal)
                                && Emprestimo.listaEmprestimos.get(i).getLivro().getGenero().getCodigo() == (jCGenero.getSelectedIndex())) {
                            emprestimosFiltrados.add(Emprestimo.listaEmprestimos.get(i));
                        }

                    }
                }

                if (emprestimosFiltrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NÃO HÁ REGISTROS DE EMPRÉSTIMO NO PERÍODO INFORMADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                    txtDataFinal.grabFocus();
                } else {
                    for (int i = 0; i < emprestimosFiltrados.size(); i++) {
                        dtmRelEmprestimo.addRow(new Object[]{
                            emprestimosFiltrados.get(i).getCodigo(),
                            emprestimosFiltrados.get(i).getAluno().getCodigo(),
                            emprestimosFiltrados.get(i).getAluno().getNome(),
                            emprestimosFiltrados.get(i).getLivro().getTitulo(),
                            emprestimosFiltrados.get(i).getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            emprestimosFiltrados.get(i).getSituacao(),});
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
            java.util.logging.Logger.getLogger(InterfaceRelatorioFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRelatorioFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceRelatorioFiltro dialog = new InterfaceRelatorioFiltro(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRelEmprestimo;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables
}
