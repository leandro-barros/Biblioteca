package Interface;

import Classes.Autor;
import Classes.Emprestimo;
import Classes.Genero;
import Classes.Livro;
import Util.Functions;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceLivro extends javax.swing.JDialog {

    public boolean alterar;

    public InterfaceLivro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        for (int i = 0; i < Genero.listaGeneros.size(); i++) {
            jCGenero.addItem(Genero.listaGeneros.get(i).getNomeGenero());
        }

        for (int i = 0; i < Autor.listaAutores.size(); i++) {
            jCAutor.addItem(Autor.listaAutores.get(i).getNomeAutor());
        }

        listarLivros();
        setModal(true);
        
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);

        jTabPane.setEnabledAt(0, false);
        jTabPane.setSelectedIndex(1);
        controlarCampos(false);

    }

    public void controlarCampos(boolean op) {
        txtTitulo.setEditable(op);
        txtEditora.setEditable(op);
        txtEdicao.setEditable(op);
        txtQuantidadeExemplares.setEditable(op);
        txtAno.setEditable(op);
        jCGenero.setEnabled(op);
        jCAutor.setEnabled(op);
    }

    public void limpaCampos() {
        txtTitulo.setText("");
        txtEditora.setText("");
        txtEdicao.setText("");
        txtQuantidadeExemplares.setText("");
        txtAno.setText("");
        jCAutor.setSelectedIndex(0);
        jCGenero.setSelectedIndex(0);
    }

    public void listarLivros() {
        DefaultTableModel dtm = (DefaultTableModel) jTableLivro.getModel();
        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            dtm.addRow(new Object[]{
                Livro.listaLivros.get(i).getCodigo(),
                Livro.listaLivros.get(i).getTitulo(),
                Livro.listaLivros.get(i).getAutor().getNomeAutor(),
                Livro.listaLivros.get(i).getEdicao(),
                Livro.listaLivros.get(i).getGenero().getNomeGenero(),
                Livro.listaLivros.get(i).getQuantidadeExemplares(),
                Livro.listaLivros.get(i).getQuantidadeDisponivel(),});
        }
    }

    public boolean validaCampos() {
        if (jCGenero.getSelectedIndex() == 0 && Functions.isEmpty(txtTitulo.getText()) && Functions.isEmpty(txtEdicao.getText())
                && jCAutor.getSelectedIndex() == 0 && Functions.isEmpty(txtEditora.getText()) && Functions.isEmpty(txtAno.getText())
                && Functions.isEmpty(txtQuantidadeExemplares.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCGenero.grabFocus();
        } else if (Functions.isEmpty(txtTitulo.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O TÍTULO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtTitulo.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtEdicao.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A EDIÇÃO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtEdicao.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtEditora.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A EDITORA !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtEditora.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtAno.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O ANO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtAno.grabFocus();
            return false;
        } else if (jCGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O GÊNERO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCGenero.grabFocus();
            return false;
        } else if (jCAutor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O AUTOR !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCAutor.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtQuantidadeExemplares.getText()) || Integer.parseInt(txtQuantidadeExemplares.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A QUANTIDADE DE EXEMPLARES !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtQuantidadeExemplares.grabFocus();
            return false;
        } else if (alterar == true) {
            int qtdLivrosEmpresado = Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeExemplares()
                    - Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeDisponivel();
            if (Integer.parseInt(txtQuantidadeExemplares.getText())
                    <= qtdLivrosEmpresado) {
                JOptionPane.showMessageDialog(null, "QUANTIDADE DE EXEMPLARES DEVE SER MAIOR QUE " + qtdLivrosEmpresado + " !", "Atenção", JOptionPane.WARNING_MESSAGE);
                txtQuantidadeExemplares.grabFocus();
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEdicao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidadeExemplares = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtEditora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCAutor = new javax.swing.JComboBox<>();
        jCGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivro = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO LIVRO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("CÓDIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, -1));

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 60, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("TÍTULO*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("AUTOR*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        txtEdicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdicaoFocusLost(evt);
            }
        });
        txtEdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdicaoKeyTyped(evt);
            }
        });
        jPanel1.add(txtEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("EDIÇÃO*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("QUANTIDADE EXEMPLARES*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 170, -1));

        txtQuantidadeExemplares.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeExemplaresFocusLost(evt);
            }
        });
        txtQuantidadeExemplares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeExemplaresKeyTyped(evt);
            }
        });
        jPanel1.add(txtQuantidadeExemplares, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 80, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 169, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 169, 55));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 800, 10));
        jPanel1.add(txtEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 310, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("EDITORA*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtAno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnoFocusLost(evt);
            }
        });
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("GÊNERO*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("ANO*");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jCAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        jPanel1.add(jCAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 200, -1));

        jCGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        jPanel1.add(jCGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 200, -1));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*) Campos obrigatórios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jTabPane.addTab("CADASTRO", jPanel1);

        jTableLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TÍTULO", "AUTOR", "EDIÇÃO", "GÊNERO", "QTD.EXEMPLARES", "QTD.DISPONÍVEIS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
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
        jTableLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableLivroMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivro);
        if (jTableLivro.getColumnModel().getColumnCount() > 0) {
            jTableLivro.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableLivro.getColumnModel().getColumn(3).setMaxWidth(60);
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
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabPane.addTab("CONSULTA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            String titulo = txtTitulo.getText().trim();
            titulo = Functions.spaceRemover(titulo);

            String editora = txtEditora.getText().trim();
            editora = Functions.spaceRemover(editora);

            Integer edicao = Integer.parseInt(Functions.spaceRemover(txtEdicao.getText()));

            Integer ano = Integer.parseInt(txtAno.getText());

            Integer quantidadeExemplares = Integer.parseInt(txtQuantidadeExemplares.getText());

            if (alterar == false) {
                Livro livro = new Livro();
                livro.cadastrar(codigo, titulo, Autor.listaAutores.get(jCAutor.getSelectedIndex() - 1), editora, edicao, ano, Genero.listaGeneros.get(jCGenero.getSelectedIndex() - 1), quantidadeExemplares);
                Livro.listaLivros.add(livro);

                DefaultTableModel dtm = (DefaultTableModel) jTableLivro.getModel();
                int ultimaPos = Livro.listaLivros.size() - 1;
                dtm.addRow(new Object[]{
                    Livro.listaLivros.get(ultimaPos).getCodigo(),
                    Livro.listaLivros.get(ultimaPos).getTitulo(),
                    Livro.listaLivros.get(ultimaPos).getAutor().getNomeAutor(),
                    Livro.listaLivros.get(ultimaPos).getEdicao(),
                    Livro.listaLivros.get(ultimaPos).getGenero().getNomeGenero(),
                    Livro.listaLivros.get(ultimaPos).getQuantidadeExemplares(),
                    Livro.listaLivros.get(ultimaPos).getQuantidadeDisponivel(),
                    Livro.listaLivros.get(ultimaPos).getEditora(),
                    Livro.listaLivros.get(ultimaPos).getAno(),});
                JOptionPane.showMessageDialog(null, "REGISTRO SALVO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Livro.incrementaCodigo++;
                txtCodigo.setText(String.valueOf(Genero.incrementaCodigo));
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                alterar = false;
                int qtdLivrosEmpresado = Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeExemplares()
                        - Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeDisponivel();

                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setCodigo(codigo);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setTitulo(titulo);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setAutor(Autor.listaAutores.get(jCAutor.getSelectedIndex() - 1));
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setEditora(editora);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setEdicao(edicao);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setAno(ano);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setGenero(Genero.listaGeneros.get(jCGenero.getSelectedIndex() - 1));
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setQuantidadeExemplares(quantidadeExemplares);
                Livro.listaLivros.get(jTableLivro.getSelectedRow()).setQuantidadeDisponivel(
                        quantidadeExemplares - qtdLivrosEmpresado);

                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getCodigo(), jTableLivro.getSelectedRow(), 0);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getTitulo(), jTableLivro.getSelectedRow(), 1);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getAutor().getNomeAutor(), jTableLivro.getSelectedRow(), 2);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getEdicao(), jTableLivro.getSelectedRow(), 3);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getGenero().getNomeGenero(), jTableLivro.getSelectedRow(), 4);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeExemplares(), jTableLivro.getSelectedRow(), 5);
                jTableLivro.setValueAt(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getQuantidadeDisponivel(), jTableLivro.getSelectedRow(), 6);
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
        if (jCGenero.getSelectedIndex() != 0 || !Functions.isEmpty(txtTitulo.getText()) || !Functions.isEmpty(txtEdicao.getText())
                || jCAutor.getSelectedIndex() != 0 || !Functions.isEmpty(txtEditora.getText()) || !Functions.isEmpty(txtAno.getText())
                || !Functions.isEmpty(txtQuantidadeExemplares.getText())) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "CANCELAR OPERAÇÃO ?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                jTabPane.setSelectedIndex(1);
                controlarCampos(false);
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                jCGenero.grabFocus();
            }
        } else {
            jTabPane.setSelectedIndex(1);
            controlarCampos(false);
            jTabPane.setEnabledAt(0, false);
            jTabPane.setEnabledAt(1, true);
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTableLivroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivroMouseReleased
        if (jTableLivro.getSelectedRow() != -1) {
            txtCodigo.setText(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 0).toString());
            txtTitulo.setText(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 1).toString());
            jCAutor.setSelectedItem(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 2).toString());
            txtEditora.setText(Livro.listaLivros.get(jTableLivro.getSelectedRow()).getEditora());
            txtEdicao.setText(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 3).toString());
            txtAno.setText((Livro.listaLivros.get(jTableLivro.getSelectedRow()).getAno().toString()));
            jCGenero.setSelectedItem(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 4).toString());
            txtQuantidadeExemplares.setText(jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 5).toString());
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_jTableLivroMouseReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        limpaCampos();
        txtCodigo.setText(String.valueOf(Livro.incrementaCodigo));
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        btnAlterar.setEnabled(false);
        alterar = false;
        txtTitulo.grabFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        btnAlterar.setEnabled(false);
        alterar = true;
        txtTitulo.grabFocus();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel dtmLivro = (DefaultTableModel) jTableLivro.getModel();
        boolean verificaEmprestimo = false;
        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (Emprestimo.listaEmprestimos.get(i).getSituacao().equals("EMPRESTADO")
                    || Emprestimo.listaEmprestimos.get(i).getSituacao().equals("RENOVADO")) {
                if (jTableLivro.getValueAt(jTableLivro.getSelectedRow(), 0) == Emprestimo.listaEmprestimos.get(i).getLivro().getCodigo()) {
                    verificaEmprestimo = true;
                }
            }
        }

        if (verificaEmprestimo == true) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL EXCLUIR LIVRO! LIVRO POSSUI EMPRÉSTIMO REGISTRADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "TEM CERTEZA QUE DESEJA EXCLUIR O LIVRO SELECIONADO?", "Atenção!", JOptionPane.YES_NO_OPTION);
            int opcaoSelecionada = jTableLivro.getSelectedRow();
            if (opcao == JOptionPane.YES_OPTION) {
                dtmLivro.removeRow(opcaoSelecionada);
                Livro.listaLivros.remove(opcaoSelecionada);
                JOptionPane.showMessageDialog(null, "REGISTRO EXCLUÍDO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtQuantidadeExemplaresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeExemplaresFocusLost
        if (Integer.parseInt(txtQuantidadeExemplares.getText()) == 0) {
            txtQuantidadeExemplares.setText("");
        }
    }//GEN-LAST:event_txtQuantidadeExemplaresFocusLost

    private void txtQuantidadeExemplaresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeExemplaresKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtQuantidadeExemplaresKeyTyped

    private void txtEdicaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdicaoKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtEdicaoKeyTyped

    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtAnoKeyTyped

    private void txtEdicaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdicaoFocusLost
        if (Integer.parseInt(txtEdicao.getText()) == 0) {
            txtEdicao.setText("");
        }
    }//GEN-LAST:event_txtEdicaoFocusLost

    private void txtAnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnoFocusLost
        if (Integer.parseInt(txtAno.getText()) == 0) {
            txtAno.setText("");
        }
    }//GEN-LAST:event_txtAnoFocusLost

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
            java.util.logging.Logger.getLogger(InterfaceLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceLivro dialog = new InterfaceLivro(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCAutor;
    private javax.swing.JComboBox<String> jCGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabPane;
    private javax.swing.JTable jTableLivro;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdicao;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtQuantidadeExemplares;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
