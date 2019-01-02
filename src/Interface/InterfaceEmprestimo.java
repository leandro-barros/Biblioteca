package Interface;

import Classes.Emprestimo;
import Classes.Aluno;
import Classes.Autor;
import Classes.Genero;
import Classes.Livro;
import Util.Functions;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Leandro
 */
public class InterfaceEmprestimo extends javax.swing.JDialog {

    String recebePrevDevolucao = null;

    public InterfaceEmprestimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Collections.sort(Aluno.listaAlunos, Comparator.comparing(Aluno::getCodigo));
        coloreTable();

        for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
            if (Aluno.listaAlunos.get(i).getSituacao().equals("MULTADO")) {
                for (int j = 0; j < Emprestimo.listaEmprestimos.size(); j++) {
                    if (Aluno.listaAlunos.get(i).getDataMulta() != null) {
                        if (Aluno.listaAlunos.get(i).getCodigo() == Emprestimo.listaEmprestimos.get(j).getAluno().getCodigo()
                                && Aluno.listaAlunos.get(i).getDataMulta().isBefore(LocalDate.now())) {
                            Aluno.listaAlunos.get(i).setSituacao("");
                        }
                    }
                }
            }
        }

        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (Emprestimo.listaEmprestimos.get(i).getSituacao().equalsIgnoreCase("EMPRESTADO")
                    && Emprestimo.listaEmprestimos.get(i).getDataPrevisaoDevolucao().isBefore(LocalDate.now())) {
                for (int j = 0; j < Aluno.listaAlunos.size(); j++) {
                    if (Emprestimo.listaEmprestimos.get(i).getAluno().getCodigo() == (Aluno.listaAlunos.get(j).getCodigo())) {
                        Aluno.listaAlunos.get(j).setSituacao("MULTADO");
                    }
                }
            }
        }

        txtDataEmprestimo.setText(Functions.dataString(LocalDate.now()));
        listarEmprestimos();
        setModal(true);
        setResizable(false);
        btnDevolver.setEnabled(false);
        btnRenovar.setEnabled(false);

        jTabPane.setEnabledAt(0, false);
        jTabPane.setSelectedIndex(1);
        controlarCampos(false);

        for (int i = 0; i < Genero.listaGeneros.size(); i++) {
            jCGenero.addItem(Genero.listaGeneros.get(i).getNomeGenero());
        }

        for (int i = 0; i < Autor.listaAutores.size(); i++) {
            jCAutor.addItem(Autor.listaAutores.get(i).getNomeAutor());
        }

        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
        }
    }

    public void coloreTable() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String str = (String) value;

                if ("EMPRESTADO".equals(str)) {
                    c.setForeground(Color.orange);
                } else if ("RENOVADO".equals(str)) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        };
        jTableEmprestimo.getColumnModel().getColumn(7).setCellRenderer(renderer);
        jTableEmprestimo.getColumnModel().getColumn(6).setCellRenderer(renderer);
    }

    public void controlarCampos(boolean op) {
        jCLivro.setEnabled(op);
        jCGenero.setEnabled(op);
    }

    public void limpaCampos() {
        jCLivro.setSelectedIndex(0);
        jCGenero.setSelectedIndex(0);
        jCAutor.setSelectedIndex(0);
        txtCodAluno.setText("");
        txtNomeAluno.setText("");
    }

    public void listarEmprestimos() {
        DefaultTableModel dtm = (DefaultTableModel) jTableEmprestimo.getModel();
        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (Emprestimo.listaEmprestimos.get(i).getSituacao().equalsIgnoreCase("EMPRESTADO")
                    || Emprestimo.listaEmprestimos.get(i).getSituacao().equalsIgnoreCase("RENOVADO")) {
                dtm.addRow(new Object[]{
                    Emprestimo.listaEmprestimos.get(i).getCodigo(),
                    Emprestimo.listaEmprestimos.get(i).getAluno().getCodigo(),
                    Emprestimo.listaEmprestimos.get(i).getAluno().getNome(),
                    Emprestimo.listaEmprestimos.get(i).getLivro().getCodigo(),
                    Emprestimo.listaEmprestimos.get(i).getLivro().getTitulo(),
                    Emprestimo.listaEmprestimos.get(i).getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    Emprestimo.listaEmprestimos.get(i).getDataPrevisaoDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    Emprestimo.listaEmprestimos.get(i).getSituacao(),});
            }
        }
    }

    public boolean alunoExiste(int codigo) {
        for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
            if (Aluno.listaAlunos.get(i).getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaAlunoPossuiExemplar(int codigo) {
        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (Emprestimo.listaEmprestimos.get(i).getSituacao().equalsIgnoreCase("EMPRESTADO")
                    || (Emprestimo.listaEmprestimos.get(i).getSituacao().equalsIgnoreCase("RENOVADO"))) {
                if (Emprestimo.listaEmprestimos.get(i).getAluno().getCodigo() == codigo) {
                    if (Emprestimo.listaEmprestimos.get(i).getLivro().getCodigo() == jCLivro.getSelectedIndex()) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean verificarQtdExemplares() {
        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            if ((jCLivro.getSelectedIndex() == Livro.listaLivros.get(i).getCodigo()) && (Livro.listaLivros.get(i).getQuantidadeDisponivel() == 1)) {
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
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtDataEmprestimo = new javax.swing.JFormattedTextField();
        jCLivro = new javax.swing.JComboBox<>();
        txtCodAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jCGenero = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jCAutor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimo = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnRenovar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EMPRÉSTIMO DE LIVRO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NOME ALUNO*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("TÍTULO DO LIVRO*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 120, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 169, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 169, 55));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 910, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("DATA EMPRÉSTIMO*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        try {
            txtDataEmprestimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataEmprestimo.setToolTipText("");
        txtDataEmprestimo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDataEmprestimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataEmprestimoFocusLost(evt);
            }
        });
        jPanel1.add(txtDataEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 120, -1));

        jCLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        jCLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCLivroFocusLost(evt);
            }
        });
        jCLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCLivroActionPerformed(evt);
            }
        });
        jPanel1.add(jCLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 250, -1));

        txtCodAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodAlunoFocusLost(evt);
            }
        });
        txtCodAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAlunoActionPerformed(evt);
            }
        });
        txtCodAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodAlunoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CÓDIGO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("CÓDIGO ALUNO*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtNomeAluno.setEditable(false);
        txtNomeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAlunoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomeAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 330, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("PREENCHA OS CAMPOS PARA FILTRAR LIVROS"));

        jCGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        jCGenero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCGeneroFocusLost(evt);
            }
        });
        jCGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCGeneroMouseExited(evt);
            }
        });
        jCGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCGeneroActionPerformed(evt);
            }
        });
        jCGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCGeneroKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("AUTOR");

        jCAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        jCAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAutorFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("GÊNERO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jCGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jCAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(5, 5, 5)
                        .addComponent(jCGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(jCAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 450, 90));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*) Campos obrigatórios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jTabPane.addTab("CADASTRO", jPanel1);

        jTableEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "COD.ALUNO", "ALUNO", "COD.LIVRO", "LIVRO", "DATA EMPRÉSTIMO", "DATA PREV. DEVOLUÇÃO", "SITUAÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableEmprestimoMouseReleased(evt);
            }
        });
        jTableEmprestimo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTableEmprestimoComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmprestimo);
        if (jTableEmprestimo.getColumnModel().getColumnCount() > 0) {
            jTableEmprestimo.getColumnModel().getColumn(0).setMaxWidth(59);
            jTableEmprestimo.getColumnModel().getColumn(1).setMaxWidth(99);
            jTableEmprestimo.getColumnModel().getColumn(3).setMaxWidth(89);
        }

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/devolver.png"))); // NOI18N
        btnDevolver.setText("DEVOLVER");
        btnDevolver.setToolTipText("");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sair.png"))); // NOI18N
        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnRenovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/renovar.png"))); // NOI18N
        btnRenovar.setText("RENOVAR");
        btnRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabPane.addTab("CONSULTA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEmprestimoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmprestimoMouseReleased
        if (jTableEmprestimo.getSelectedRow() != -1) {
            btnDevolver.setEnabled(true);
            btnRenovar.setEnabled(true);
        }
    }//GEN-LAST:event_jTableEmprestimoMouseReleased
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        jTabPane.setSelectedIndex(0);
        controlarCampos(true);
        limpaCampos();
        txtCodigo.setText(String.valueOf(Emprestimo.incrementaCodigo));
        jTabPane.setEnabledAt(0, true);
        jTabPane.setEnabledAt(1, false);
        txtCodAluno.grabFocus();
        txtDataEmprestimo.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }//GEN-LAST:event_btnNovoActionPerformed
    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        if (!jTableEmprestimo.getValueAt(jTableEmprestimo.getSelectedRow(), 7).equals("DEVOLVIDO")) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "TEM CERTEZA QUE DESEJA DEVOLVER O EMPRÉSTIMO SELECIONADO ?", "Atenção!", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                JFormattedTextField tfcdUsuario = new JFormattedTextField();

                tfcdUsuario.setText("DATA DEVOLUÇÃO");
                String d = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                boolean validaData = false;
                String txtDataDevolucao = null;
                try {
                    while (validaData == false) {
                        txtDataDevolucao = JOptionPane.showInputDialog(tfcdUsuario.getText(), d);
                        if (Functions.isValidData(txtDataDevolucao) && Functions.dataMenorQueHoje(txtDataDevolucao)) {
                            validaData = true;
                        } else {
                            validaData = false;
                            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA DEVOLUÇÃO VÁLIDA !", "Atenção", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                    LocalDate dataDevolucao = LocalDate.parse(txtDataDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate dataPrevDevolucao = null;
                    for (int i = 0; i < Livro.listaLivros.size(); i++) {
                        if (jTableEmprestimo.getValueAt(jTableEmprestimo.getSelectedRow(), 3) == Livro.listaLivros.get(i).getCodigo()) {
                            Integer qtdDisponivel = (Livro.listaLivros.get(i).getQuantidadeDisponivel()) + 1;
                            Livro.listaLivros.get(i).setQuantidadeDisponivel(qtdDisponivel);
                        }
                    }

                    Emprestimo.listaEmprestimos.get(retornaPosicao()).setSituacao("DEVOLVIDO");
                    Emprestimo.listaEmprestimos.get(retornaPosicao()).setDataDevolucao(dataDevolucao);
                    dataPrevDevolucao = Emprestimo.listaEmprestimos.get(retornaPosicao()).getDataPrevisaoDevolucao();

                    for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
                        if (jTableEmprestimo.getValueAt(jTableEmprestimo.getSelectedRow(), 1) == Aluno.listaAlunos.get(i).getCodigo()) {
                            Integer qtdLivroEmprestado = (Aluno.listaAlunos.get(i).getQuantidadeLivro()) - 1;
                            Aluno.listaAlunos.get(i).setQuantidadeLivro(qtdLivroEmprestado);

                            if (Aluno.listaAlunos.get(i).getDataMulta() == null || Aluno.listaAlunos.get(i).getDataMulta().isBefore(LocalDate.now())) {
                                if (Aluno.listaAlunos.get(i).getSituacao().equalsIgnoreCase("MULTADO")) {
                                    if (dataPrevDevolucao.isAfter(dataDevolucao) || dataPrevDevolucao.isEqual(dataDevolucao)) {
                                        Aluno.listaAlunos.get(i).setSituacao("");

                                    }
                                }
                            }
                            int contaDiasFimSemana = 0;
                            int qtdDiasMulta = 0;
                            if (dataPrevDevolucao.isBefore(dataDevolucao)) {
                                qtdDiasMulta = Functions.diferencaDias(dataPrevDevolucao, dataDevolucao);
                                for (int j = 1; j <= qtdDiasMulta; j++) {
                                    if (Functions.fimDeSemana(dataDevolucao.plusDays(j)) == true) {
                                        contaDiasFimSemana++;
                                    }
                                }
                                if (contaDiasFimSemana > 0) {
                                    qtdDiasMulta = qtdDiasMulta + contaDiasFimSemana;
                                }
                                if (Aluno.listaAlunos.get(i).getDataMulta() != null) {
                                    if (Aluno.listaAlunos.get(i).getDataMulta().isBefore(dataDevolucao.plusDays(qtdDiasMulta))) {
                                        Aluno.listaAlunos.get(i).setDataMulta(dataDevolucao.plusDays(qtdDiasMulta));
                                        Aluno.listaAlunos.get(i).setSituacao("MULTADO");
                                        JOptionPane.showMessageDialog(null, "EMPRÉSTIMO DEVOLVIDO COM ATRASO ! \n ALUNO " + Aluno.listaAlunos.get(i).getNome()
                                                + " ESTÁ COM MULTA REFERENTE A ESTE EMPRÉSTIMO ATÉ A DATA " + Aluno.listaAlunos.get(i).getDataMulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                + "", "Atenção", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    Aluno.listaAlunos.get(i).setDataMulta(dataDevolucao.plusDays(qtdDiasMulta));
                                    Aluno.listaAlunos.get(i).setSituacao("MULTADO");
                                    JOptionPane.showMessageDialog(null, "EMPRÉSTIMO DEVOLVIDO COM ATRASO ! \n ALUNO " + Aluno.listaAlunos.get(i).getNome()
                                            + " ESTÁ COM MULTA REFERENTE A ESTE EMPRÉSTIMO ATÉ A DATA " + Aluno.listaAlunos.get(i).getDataMulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                            + "", "Atenção", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    }
                    jTableEmprestimo.setValueAt("DEVOLVIDO", jTableEmprestimo.getSelectedRow(), 7);
                    JOptionPane.showMessageDialog(null, "EMPRÉSTIMO DEVOLVIDO COM SUCESSO !", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                } catch (NullPointerException e) {
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LIVRO JÁ FOI DEVOLVIDO !", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!Functions.isEmpty(txtCodigo.getText()) || jCLivro.getSelectedIndex() == 0
                || !txtDataEmprestimo.getText().equals("  /  /    ")) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "CANCELAR OPERAÇÃO ?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                jTabPane.setSelectedIndex(1);
                controlarCampos(false);
                jTabPane.setEnabledAt(0, false);
                jTabPane.setEnabledAt(1, true);
            } else {
                txtCodAluno.grabFocus();
            }
        } else {
            jTabPane.setSelectedIndex(1);
            controlarCampos(false);
            jTabPane.setEnabledAt(0, false);
            jTabPane.setEnabledAt(1, true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    public boolean validaCampos() {
        if (Functions.isEmpty(txtCodAluno.getText()) && jCLivro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtNomeAluno.grabFocus();
            return false;
        } else if (Functions.isEmpty(txtCodAluno.getText())) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O CÓDIGO DO ALUNO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtCodAluno.grabFocus();
            return false;
        } else if (jCLivro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME O LIVRO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCLivro.grabFocus();
            return false;
        } else if (txtDataEmprestimo.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME A DATA DE EMPRÉSTIMO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataEmprestimo.grabFocus();
            return false;
        } else if (Functions.isValidData(txtDataEmprestimo.getText()) == false) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, INFORME UMA DATA DE EMPRÉSTIMO VÁLIDA !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataEmprestimo.grabFocus();
            return false;
        } else if (Functions.dataMenorQueHoje(txtDataEmprestimo.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DATA EMPRÉSTIMO NÃO PODE SER POSTERIOR À DATA DE ATUAL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtDataEmprestimo.grabFocus();
            return false;
        } else if (verificarQtdExemplares() == false) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL REALIZAR EMPRÉSTIMO !\n LIVRO COM  APENAS 1 EXEMPLAR DISPONÍVEL !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCLivro.grabFocus();
            jCLivro.setSelectedIndex(0);
            return false;
        } else if (verificaAlunoPossuiExemplar(Integer.parseInt(txtCodAluno.getText())) == true) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL REALIZAR EMPRÉSTIMO !\n ALUNO ESTÁ COM 1 EXEMPLAR DO LIVRO SELECIONADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
            jCLivro.grabFocus();
            jCLivro.setSelectedIndex(0);
            return false;
        }
        return true;
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaCampos() == false) {

        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            LocalDate dataEmprestimo = LocalDate.parse(txtDataEmprestimo.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            LocalDate dataPrevDevolucao = dataEmprestimo.plusDays(7);
            recebePrevDevolucao = Functions.dataString(dataPrevDevolucao);

            LocalDate dataPrevisaoDevolucao = LocalDate.parse(recebePrevDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.cadastrar(codigo, Livro.listaLivros.get(jCLivro.getSelectedIndex() - 1), Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1), dataEmprestimo, dataPrevisaoDevolucao, "EMPRESTADO");
            Emprestimo.listaEmprestimos.add(emprestimo);

            DefaultTableModel dtm = (DefaultTableModel) jTableEmprestimo.getModel();
            int ultimaPos = Emprestimo.listaEmprestimos.size() - 1;

            dtm.addRow(new Object[]{
                Emprestimo.listaEmprestimos.get(ultimaPos).getCodigo(),
                Emprestimo.listaEmprestimos.get(ultimaPos).getAluno().getCodigo(),
                Emprestimo.listaEmprestimos.get(ultimaPos).getAluno().getNome(),
                Emprestimo.listaEmprestimos.get(ultimaPos).getLivro().getCodigo(),
                Emprestimo.listaEmprestimos.get(ultimaPos).getLivro().getTitulo(),
                Emprestimo.listaEmprestimos.get(ultimaPos).getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Emprestimo.listaEmprestimos.get(ultimaPos).getDataPrevisaoDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Emprestimo.listaEmprestimos.get(ultimaPos).getSituacao(),});

            JOptionPane.showMessageDialog(null, "EMPRÉSTIMO REALIZADO COM SUCESSO !", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            Emprestimo.incrementaCodigo++;
            txtCodigo.setText(String.valueOf(Emprestimo.incrementaCodigo));

            Integer posLivroCadastrado = jCLivro.getSelectedIndex() - 1;
            Integer qtdDisponivel = (Livro.listaLivros.get(posLivroCadastrado).getQuantidadeDisponivel());
            Integer diminui = qtdDisponivel - 1;
            Livro.listaLivros.get(posLivroCadastrado).setQuantidadeDisponivel(diminui);

            Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1).setQuantidadeLivro(
                    (Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1).getQuantidadeLivro()) + 1);

            Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1).setQuantidadeEmprestimo(
                    (Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1).getQuantidadeEmprestimo()) + 1);

            Aluno.listaAlunos.get(Integer.parseInt(txtCodAluno.getText()) - 1).setSituacao("");

            jTabPane.setEnabledAt(0, false);
            jTabPane.setEnabledAt(1, true);

            controlarCampos(false);
            limpaCampos();
            btnDevolver.setEnabled(false);
            btnRenovar.setEnabled(false);
            jTabPane.setSelectedIndex(1);
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodAlunoActionPerformed

    private void txtNomeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAlunoActionPerformed

    private void jCGeneroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCGeneroFocusLost
        jCLivro.removeAllItems();
        jCLivro.addItem("SELECIONE");
        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            if (jCGenero.getSelectedIndex() != 0 && jCAutor.getSelectedIndex() != 0) {
                if (jCGenero.getSelectedIndex() == Livro.listaLivros.get(i).getGenero().getCodigo()
                        && jCAutor.getSelectedIndex() == Livro.listaLivros.get(i).getAutor().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCAutor.getSelectedIndex() != 0 && jCGenero.getSelectedIndex() == 0) {
                if (jCAutor.getSelectedIndex() == Livro.listaLivros.get(i).getAutor().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCAutor.getSelectedIndex() == 0 && jCGenero.getSelectedIndex() != 0) {
                if (jCGenero.getSelectedIndex() == Livro.listaLivros.get(i).getGenero().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCGenero.getSelectedIndex() == 0 && jCAutor.getSelectedIndex() == 0) {
                jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
            }
        }
    }//GEN-LAST:event_jCGeneroFocusLost

    private void jCGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCGeneroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCGeneroActionPerformed

    private void jCGeneroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCGeneroMouseExited


    }//GEN-LAST:event_jCGeneroMouseExited

    private void txtCodAlunoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAlunoFocusLost
        if (!txtCodAluno.getText().equals("")) {
            int codigo = Integer.parseInt(txtCodAluno.getText());
            boolean existeAluno = alunoExiste(codigo);

            for (int i = 0; i < Aluno.listaAlunos.size(); i++) {
                if (Aluno.listaAlunos.get(i).getCodigo() == codigo) {
                    if (Aluno.listaAlunos.get(i).getQuantidadeLivro() == 3) {
                        JOptionPane.showMessageDialog(null, "ESTE ALUNO ESTÁ COM 3 LIVROS EMPRESTADO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                        txtCodAluno.requestFocus();
                        txtCodAluno.setText("");
                    } else if (Aluno.listaAlunos.get(i).getSituacao().equalsIgnoreCase("MULTADO")) {
                        if (Aluno.listaAlunos.get(i).getDataMulta() != null) {
                            JOptionPane.showMessageDialog(null, "ALUNO COM MULTA POR ATRASO NA DEVOLUÇÃO ! \n ALUNO " + Aluno.listaAlunos.get(i).getNome()
                                    + " PODERÁ OBTER EMPRÉSTIMO A PARTIR DA DATA " + Aluno.listaAlunos.get(i).getDataMulta().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                    + "", "Atenção", JOptionPane.WARNING_MESSAGE);
                            txtCodAluno.requestFocus();
                            txtCodAluno.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "ALUNO COM MULTA POR ATRASO NA DEVOLUÇÃO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                            txtCodAluno.requestFocus();
                            txtCodAluno.setText("");
                        }
                    } else {
                        txtNomeAluno.setText(Aluno.listaAlunos.get(i).getNome());
                    }
                }
            }
            if (existeAluno == false) {
                JOptionPane.showMessageDialog(null, "NÃO EXISTE ALUNO COM ESSE CÓDIGO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                txtCodAluno.setText("");
                txtNomeAluno.setText("");
                txtCodAluno.requestFocus();
            }
        } else {
            txtNomeAluno.setText("");
        }
    }//GEN-LAST:event_txtCodAlunoFocusLost

    private void jCGeneroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCGeneroKeyPressed

    }//GEN-LAST:event_jCGeneroKeyPressed

    private void jCAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAutorFocusLost
        jCLivro.removeAllItems();
        jCLivro.addItem("SELECIONE");
        for (int i = 0; i < Livro.listaLivros.size(); i++) {
            if (jCGenero.getSelectedIndex() != 0 && jCAutor.getSelectedIndex() != 0) {
                if (jCGenero.getSelectedIndex() == Livro.listaLivros.get(i).getGenero().getCodigo()
                        && jCAutor.getSelectedIndex() == Livro.listaLivros.get(i).getAutor().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCAutor.getSelectedIndex() != 0 && jCGenero.getSelectedIndex() == 0) {
                if (jCAutor.getSelectedIndex() == Livro.listaLivros.get(i).getAutor().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCAutor.getSelectedIndex() == 0 && jCGenero.getSelectedIndex() != 0) {
                if (jCGenero.getSelectedIndex() == Livro.listaLivros.get(i).getGenero().getCodigo()) {
                    jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
                }
            } else if (jCGenero.getSelectedIndex() == 0 && jCAutor.getSelectedIndex() == 0) {
                jCLivro.addItem(Livro.listaLivros.get(i).getTitulo());
            }
        }
    }//GEN-LAST:event_jCAutorFocusLost

    private void jCLivroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCLivroFocusLost
    }//GEN-LAST:event_jCLivroFocusLost

    public int retornaPosicao() {
        int pos = 0;
        for (int i = 0; i < Emprestimo.listaEmprestimos.size(); i++) {
            if (jTableEmprestimo.getValueAt(jTableEmprestimo.getSelectedRow(), 0) == Emprestimo.listaEmprestimos.get(i).getCodigo()) {
                pos = i;
            }
        }
        return pos;
    }
    private void btnRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarActionPerformed
        boolean verificaRenovacao = true;
        int recebePosAluno = 0;

        if (Emprestimo.listaEmprestimos.get(retornaPosicao()).getQuantidadeRenovacao() > 1) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL RENOVAR ! \n JÁ FORAM FEITAS AS DUAS RENOVAÇÕES PERMITIDAS !", "Atenção", JOptionPane.WARNING_MESSAGE);
            verificaRenovacao = false;
        }
        if (verificaRenovacao == true) {
            if (jTableEmprestimo.getValueAt(jTableEmprestimo.getSelectedRow(), 7).equals("DEVOLVIDO")) {
                JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL RENOVAR ! \n LIVRO JÁ FOI DEVOLVIDO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                verificaRenovacao = false;
            }
        }
        if (verificaRenovacao == true) {
            if (Emprestimo.listaEmprestimos.get(retornaPosicao()).getDataPrevisaoDevolucao().isBefore(
                    LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL RENOVAR ! \n EMPRÉSTIMO COM ATRASO NA DEVOLUÇÃO !", "Atenção", JOptionPane.WARNING_MESSAGE);
                verificaRenovacao = false;
            }
        }

        if (verificaRenovacao == true) {
            int opcao = JOptionPane.showConfirmDialog(rootPane, "TEM CERTEZA QUE DESEJA RENOVAR O EMPRÉSTIMO SELECIONADO?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {

                LocalDate dataRenovacao = null;
                dataRenovacao = Emprestimo.listaEmprestimos.get(retornaPosicao()).getDataPrevisaoDevolucao().plusDays(7);
                Emprestimo.listaEmprestimos.get(retornaPosicao()).setDataPrevisaoDevolucao(dataRenovacao);
                Emprestimo.listaEmprestimos.get(retornaPosicao()).setSituacao("RENOVADO");
                jTableEmprestimo.setValueAt("RENOVADO", jTableEmprestimo.getSelectedRow(), 7);
                jTableEmprestimo.setValueAt(dataRenovacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), jTableEmprestimo.getSelectedRow(), 6);
                Emprestimo.listaEmprestimos.get(retornaPosicao()).setQuantidadeRenovacao(
                        Emprestimo.listaEmprestimos.get(retornaPosicao()).getQuantidadeRenovacao() + 1);
                JOptionPane.showMessageDialog(null, "EMPRÉSTIMO RENOVADO COM SUCESSO !", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnRenovarActionPerformed

    private void txtCodAlunoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAlunoKeyTyped
        Functions.soNumeros(evt);
    }//GEN-LAST:event_txtCodAlunoKeyTyped

    private void jCLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCLivroActionPerformed

    private void jTableEmprestimoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTableEmprestimoComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableEmprestimoComponentShown

    private void txtDataEmprestimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataEmprestimoFocusLost
        txtDataEmprestimo.setFocusLostBehavior(JFormattedTextField.COMMIT);
    }//GEN-LAST:event_txtDataEmprestimoFocusLost

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
            java.util.logging.Logger.getLogger(InterfaceEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceEmprestimo dialog = new InterfaceEmprestimo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRenovar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> jCAutor;
    private javax.swing.JComboBox<String> jCGenero;
    private javax.swing.JComboBox<String> jCLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabPane;
    private javax.swing.JTable jTableEmprestimo;
    private javax.swing.JTextField txtCodAluno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataEmprestimo;
    private javax.swing.JTextField txtNomeAluno;
    // End of variables declaration//GEN-END:variables
}
