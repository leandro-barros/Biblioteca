package Interface;

import Classes.Aluno;
import Classes.Emprestimo;
import Util.Functions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class InterfaceAluno extends javax.swing.JDialog {

    public boolean alterar;

    public InterfaceAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Collections.sort(Aluno.listaAlunos, Comparator.comparing(Aluno::getCodigo));
        initComponents();
        listarAlunos();
        setModal(true);
        
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);

        jTabPane.setEnabledAt(0, false);
        jTabPane.setSelectedIndex(1);
        controlarCampos(false);

    }

    public void controlarCampos(boolean op) {
        txtNome.setEditable(op);
        txtEmail.setEditable(op);
        txtTelefone.setEditable(op);
        txtCpf.setEditable(op);
        txtDataNasc.setEditable(op);
        txtMatricula.setEditable(op);
    }

    public void limpaCampos() {
        txtEmail.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        txtDataNasc.setText("");
        txtMatricula.setText("");
    }

    public void listarAlunos() {
        DefaultTableModel dtm = (DefaultTableModel) jTableAluno.getModel();
        for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
            dtm.addRow(new Object[]{
                Aluno.listaAlunos.get(i).getCodigo(),
                Aluno.listaAlunos.get(i).getNome(),
                Aluno.listaAlunos.get(i).getCpf(),
                Aluno.listaAlunos.get(i).getMatricula(),
                Aluno.listaAlunos.get(i).getEmail(),
                Aluno.listaAlunos.get(i).getTelefone(),
                Aluno.listaAlunos.get(i).getDataNascimento(),});
        }
    }

    public static boolean validaDataNascimento(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        LocalDate hoje = LocalDate.now();
        return dataVerificada.compareTo(hoje) < 0;
    }

    public boolean validaCampos() {
        if (Functions.isEmpty(txtCpf.getText()) && Functions.isEmpty(txtNome.getText())
                && Functions.isEmpty(txtMatricula.getText()) && Functions.isEmpty(txtEmail.getText())
                && Functions.isEmpty(txtTelefone.getText()) && txtDataNasc.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtCpf.grabFocus();
        } else if (Functions.isEmpty(txtCpf.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O CPF !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtCpf.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtNome.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O NOME !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtNome.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtMatricula.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A MATRÍCULA !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtMatricula.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O EMAIL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtEmail.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtTelefone.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O TELEFONE !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtTelefone.grabFocus();
            return false;
        } else if (txtDataNasc.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA NASCIMENTO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataNasc.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataNasc.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA NASCIMENTO VÁLIDA !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataNasc.grabFocus();
            return false;
        } else if (validaDataNascimento(txtDataNasc.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO NÃO PODE SER IGUAL OU POSTERIOR À DATA ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataNasc.grabFocus();
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
        txtNome = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataNasc = new javax.swing.JFormattedTextField();
        txtMatricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAluno = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO ALUNO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("CÓDIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, -1));

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 60, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NOME*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 310, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("EMAIL*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CPF*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("DATA NASCIMENTO*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 120, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 169, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 169, 55));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 730, 10));

        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("TELEFONE*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNasc.setToolTipText("");
        txtDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataNascFocusLost(evt);
            }
        });
        jPanel1.add(txtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 150, -1));

        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusLost(evt);
            }
        });
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("MATRÍCULA*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*) Campos obrigatórios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jTabPane.addTab("CADASTRO", jPanel1);

        jTableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "CPF", "MATRÍCULA", "EMAIL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableAlunoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAluno);
        if (jTableAluno.getColumnModel().getColumnCount() > 0) {
            jTableAluno.getColumnModel().getColumn(0).setMaxWidth(59);
        }

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novoLeitor.png"))); // NOI18N
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
                .addGap(18, 18, 18)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabPane.addTab("CONSULTA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            String nome = txtNome.getText().trim();
            nome = Functions.spaceRemover(nome);

            String cpf = txtCpf.getText();
            String matricula = txtMatricula.getText();

            String email = txtEmail.getText().trim();
            email = Functions.spaceRemover(email);

            String telefone = txtTelefone.getText();

            LocalDate dataNasc = LocalDate.parse(txtDataNasc.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            if (alterar == false) {
                Aluno aluno = new Aluno();
                aluno.cadastrar(codigo, nome, cpf, matricula, email, telefone, dataNasc);
                Aluno.listaAlunos.add(aluno);

                DefaultTableModel dtm = (DefaultTableModel) jTableAluno.getModel();
                int ultimaPos = Aluno.listaAlunos.size() - 1;

                dtm.addRow(new Object[]{
                    Aluno.listaAlunos.get(ultimaPos).getCodigo(),
                    Aluno.listaAlunos.get(ultimaPos).getNome(),
                    Aluno.listaAlunos.get(ultimaPos).getCpf(),
                    Aluno.listaAlunos.get(ultimaPos).getMatricula(),
                    Aluno.listaAlunos.get(ultimaPos).getEmail(),
                    Aluno.listaAlunos.get(ultimaPos).getTelefone(),
                    Aluno.listaAlunos.get(ultimaPos).getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),});
                JOptionPane.showMessageDialog(null, "REGISTRO SALVO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                Aluno.incrementaCodigo++;
                txtCodigo.setText(String.valueOf(Aluno.incrementaCodigo));
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                alterar = false;
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setCodigo(codigo);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setNome(nome);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setCpf(cpf);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setMatricula(matricula);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setEmail(email);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setTelefone(telefone);
                Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).setDataNascimento(dataNasc);

                jTableAluno.setValueAt(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getCodigo(), jTableAluno.getSelectedRow(), 0);
                jTableAluno.setValueAt(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getNome(), jTableAluno.getSelectedRow(), 1);
                jTableAluno.setValueAt(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getCpf(), jTableAluno.getSelectedRow(), 2);
                jTableAluno.setValueAt(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getMatricula(), jTableAluno.getSelectedRow(), 3);
                jTableAluno.setValueAt(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getEmail(), jTableAluno.getSelectedRow(), 4);

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
        if (!Functions.isEmpty(txtCpf.getText()) || !Functions.isEmpty(txtNome.getText())
                || !Functions.isEmpty(txtMatricula.getText()) || !Functions.isEmpty(txtEmail.getText())
                || !Functions.isEmpty(txtTelefone.getText()) || !txtDataNasc.getText().equals("  /  /    ")) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "CANCELAR OPERAÇÃO ?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                jTabPane.setSelectedIndex(1);
                controlarCampos(false);
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                txtCpf.grabFocus();
            }
        } else {
            jTabPane.setSelectedIndex(1);
            controlarCampos(false);
            jTabPane.setEnabledAt(0, false);
            jTabPane.setEnabledAt(1, true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTableAlunoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunoMouseReleased
        if (jTableAluno.getSelectedRow() != -1) {
            txtCodigo.setText(jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 0).toString());
            txtNome.setText(jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 1).toString());
            txtCpf.setText(jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 2).toString());
            txtMatricula.setText(jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 3).toString());
            txtEmail.setText(jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 4).toString());
            txtTelefone.setText(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getTelefone());
            txtDataNasc.setText(Aluno.listaAlunos.get(jTableAluno.getSelectedRow()).getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }

    }//GEN-LAST:event_jTableAlunoMouseReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        limpaCampos();
        txtCodigo.setText(String.valueOf(Aluno.incrementaCodigo));
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        txtNome.grabFocus();
        btnAlterar.setEnabled(false);
        alterar = false;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        jTabPane.setSelectedIndex(0);
        btnAlterar.setEnabled(false);
        controlarCampos(true);
        alterar = true;
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        txtNome.grabFocus();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel dtmLivro = (DefaultTableModel) jTableAluno.getModel();
        boolean verificaVinculo = false;
        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (Emprestimo.listaEmprestimos.get(i).getSituacao().equals("EMPRESTADO")
                    || Emprestimo.listaEmprestimos.get(i).getSituacao().equals("RENOVADO")) {
                if (jTableAluno.getValueAt(jTableAluno.getSelectedRow(), 0) == Emprestimo.listaEmprestimos.get(i).getAluno().getCodigo()) {
                    verificaVinculo = true;
                }
            }
        }

        if (verificaVinculo == true) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL EXCLUIR !\n HÁ LIVRO EMPRESTADO A ESTE ALUNO !", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "TEM CERTEZA QUE DESEJA EXCLUIR O ALUNO SELECIONADO?", "Atenção!", JOptionPane.YES_NO_OPTION);
            int opcaoSelecionada = jTableAluno.getSelectedRow();
            if (opcao == JOptionPane.YES_OPTION) {
                dtmLivro.removeRow(opcaoSelecionada);
                Aluno.listaAlunos.remove(opcaoSelecionada);
                JOptionPane.showMessageDialog(null, "REGISTRO EXCLUÍDO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        if (Integer.parseInt(txtCpf.getText()) == 0) {
            txtCpf.setText("");
        }
    }//GEN-LAST:event_txtCpfFocusLost

    private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
        if (Integer.parseInt(txtMatricula.getText()) == 0) {
            txtMatricula.setText("");
        }
    }//GEN-LAST:event_txtMatriculaFocusLost

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtMatriculaKeyTyped

    private void txtTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtTelefoneKeyTyped

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        if (Integer.parseInt(txtTelefone.getText()) == 0) {
            txtTelefone.setText("");
        }
    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtDataNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataNascFocusLost
        txtDataNasc.setFocusLostBehavior(JFormattedTextField.COMMIT);
    }//GEN-LAST:event_txtDataNascFocusLost

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceAluno dialog = new InterfaceAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabPane;
    private javax.swing.JTable jTableAluno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
