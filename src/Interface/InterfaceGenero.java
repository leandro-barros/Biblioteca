package Interface;

import Classes.Genero;
import Classes.Livro;
import Util.Functions;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceGenero extends javax.swing.JDialog {

    public boolean alterar;

    public InterfaceGenero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarGeneros();
        setModal(true);
        setResizable(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);

        jTabPane.setEnabledAt(0, false);
        jTabPane.setSelectedIndex(1);
        controlarCampos(false);

    }

    public void controlarCampos(boolean op) {
        txtNomeGenero.setEditable(op);
    }

    public void limpaCampos() {
        txtNomeGenero.setText("");
    }

    public void listarGeneros() {
        DefaultTableModel dtm = (DefaultTableModel) jTableGenero.getModel();
        for (int i = 0; i < Genero.listaGeneros.size(); i++) {
            dtm.addRow(new Object[]{
                Genero.listaGeneros.get(i).getCodigo(),
                Genero.listaGeneros.get(i).getNomeGenero()
            });
        }
    }

    public boolean validaCampos() {
        if (Functions.isEmpty(txtNomeGenero.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O NOME DO GÊNERO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtNomeGenero.grabFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeGenero = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGenero = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO GÊNERO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("CÓDIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        txtNomeGenero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeGeneroFocusLost(evt);
            }
        });
        jPanel1.add(txtNomeGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, -1));

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 60, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 169, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 169, 55));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 720, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NOME GÊNERO*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*) Campos obrigatórios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jTabPane.addTab("CADASTRO", jPanel1);

        jTableGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME GÊNERO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableGeneroMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGenero);
        if (jTableGenero.getColumnModel().getColumnCount() > 0) {
            jTableGenero.getColumnModel().getColumn(0).setMaxWidth(69);
        }

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sair.png"))); // NOI18N
        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabPane.addTab("CONSULTA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (validaCampos() == false) {

        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nomeGenero = txtNomeGenero.getText().trim();
            nomeGenero = Functions.spaceRemover(nomeGenero);

            if (alterar == false) {
                Genero genero = new Genero();
                genero.cadastrar(codigo, nomeGenero);
                Genero.listaGeneros.add(genero);

                DefaultTableModel dtm = (DefaultTableModel) jTableGenero.getModel();
                int ultimaPos = Genero.listaGeneros.size() - 1;

                dtm.addRow(new Object[]{
                    Genero.listaGeneros.get(ultimaPos).getCodigo(),
                    Genero.listaGeneros.get(ultimaPos).getNomeGenero()
                });
                JOptionPane.showMessageDialog(null, "REGISTRO SALVO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Genero.incrementaCodigo++;
                txtCodigo.setText(String.valueOf(Genero.incrementaCodigo));
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                alterar = false;

                Genero.listaGeneros.get(jTableGenero.getSelectedRow()).setCodigo(codigo);
                Genero.listaGeneros.get(jTableGenero.getSelectedRow()).setNomeGenero(nomeGenero);

                jTableGenero.setValueAt(Genero.listaGeneros.get(jTableGenero.getSelectedRow()).getCodigo(), jTableGenero.getSelectedRow(), 0);
                jTableGenero.setValueAt(Genero.listaGeneros.get(jTableGenero.getSelectedRow()).getNomeGenero(), jTableGenero.getSelectedRow(), 1);
                JOptionPane.showMessageDialog(null, "REGISTRO ALTERADO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            }
            controlarCampos(false);
            limpaCampos();
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            jTabPane.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!Functions.isEmpty(txtNomeGenero.getText())) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "CANCELAR OPERAÇÃO ?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                jTabPane.setSelectedIndex(1);
                controlarCampos(false);
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                txtNomeGenero.grabFocus();
            }
        } else {
            jTabPane.setSelectedIndex(1);
            controlarCampos(false);
            jTabPane.setEnabledAt(0, false);
            jTabPane.setEnabledAt(1, true);
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTableGeneroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGeneroMouseReleased
        if (jTableGenero.getSelectedRow() != -1) {
            txtCodigo.setText(jTableGenero.getValueAt(jTableGenero.getSelectedRow(), 0).toString());
            txtNomeGenero.setText(jTableGenero.getValueAt(jTableGenero.getSelectedRow(), 1).toString());
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_jTableGeneroMouseReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        limpaCampos();
        alterar = false;
        btnAlterar.setEnabled(false);
        txtCodigo.setText(String.valueOf(Genero.incrementaCodigo));
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        txtNomeGenero.grabFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        alterar = true;
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        btnAlterar.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel dtmGenero = (DefaultTableModel) jTableGenero.getModel();
        boolean verificaVinculo = false;
        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            if (jTableGenero.getValueAt(jTableGenero.getSelectedRow(), 0) == Livro.listaLivros.get(i).getGenero().getCodigo()) {
                verificaVinculo = true;
            }
        }

        if (verificaVinculo == true) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL EXCLUIR !\n HÁ LIVRO CADASTRO COM ESTE GÊNERO !", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "TEM CERTEZA QUE DESEJA EXCLUIR O GÊNERO SELECIONADO?", "Atenção!", JOptionPane.YES_NO_OPTION);
            int opcaoSelecionada = jTableGenero.getSelectedRow();
            if (opcao == JOptionPane.YES_OPTION) {
                dtmGenero.removeRow(opcaoSelecionada);
                Genero.listaGeneros.remove(opcaoSelecionada);
                JOptionPane.showMessageDialog(null, "REGISTRO EXCLUÍDO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtNomeGeneroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeGeneroFocusLost

    }//GEN-LAST:event_txtNomeGeneroFocusLost

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
            java.util.logging.Logger.getLogger(InterfaceGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceGenero dialog = new InterfaceGenero(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabPane;
    private javax.swing.JTable jTableGenero;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNomeGenero;
    // End of variables declaration//GEN-END:variables
}
