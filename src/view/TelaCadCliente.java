package view;

/**
 *
 * @author Edilson Ricardo
 */
import java.sql.*;
import dao.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaCadCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadCliente
     */
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TelaCadCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void actualizarDados() {
        String sql = "Update tbclientes set nome=?, endereco=?, telefone=?, email=? where nome=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtEndereco.getText());
            ps.setString(3, txtTelefone.getText());
            ps.setString(4, txtEmail.getText());
            ps.setString(5, txtNome.getText());
            // Validação da campos obrigatorios
            if (txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");

            } else {
                //As linhas abaixo sao usadas para confirmar a actualizar de dados na tabela
                int adicionar = ps.executeUpdate();//A linha actualiza a tabela usuarios com os dados do formulario. Poderia ter sido somente "ps.                                  executeUpdate()"
                if (adicionar > 0) {
                    JOptionPane.showMessageDialog(null, "Dado(s) actualizado(s) com sucesso.");
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtTelefone.setText("");
                    txtEndereco.setText("");
                    btnRegistar.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void registarClientes() {
        String sql = "Insert into tbclientes (nome, endereco, telefone, email) values (?,?,?,?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtEndereco.getText());
            ps.setString(3, txtTelefone.getText());
            ps.setString(4, txtEmail.getText());
            if (txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
            } else {
                int adicionar = ps.executeUpdate();
                if (adicionar > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente registado com sucesso.");
                    txtEmail.setText("");
                    txtEndereco.setText("");
                    txtNome.setText("");
                    txtTelefone.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisarClientes() {
        String sql = "select * from tbclientes where nome like ?";
        try {
            ps = conexao.prepareStatement(sql);
            //passagem de conteudo da caixa de pesquisa para o "?"
            //O simbolo de % é continucao da String do codigo SQL
            ps.setString(1, txtPesquisar.getText() + "%");
            rs = ps.executeQuery();
            //A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaClientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }

    private void preencherCampos() {
        int preencher = tabelaClientes.getSelectedRow();
        txtID.setText(tabelaClientes.getModel().getValueAt(preencher, 0).toString());
        txtNome.setText(tabelaClientes.getModel().getValueAt(preencher, 1).toString());
        txtEndereco.setText(tabelaClientes.getModel().getValueAt(preencher, 2).toString());
        txtTelefone.setText(tabelaClientes.getModel().getValueAt(preencher, 3).toString());
        txtEmail.setText(tabelaClientes.getModel().getValueAt(preencher, 4).toString());
        // A linha abaixo desabilita  o botao adicionar
        btnRegistar.setEnabled(false);
    }

    private void removerCliente() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "Delete from tbclientes where idcliente =?";
            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, txtID.getText());
                int removido = ps.executeUpdate();
                if (removido > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                    txtEmail.setText("");
                    txtEndereco.setText("");
                    txtID.setText("");
                    txtNome.setText("");
                    txtPesquisar.setText("");
                    txtTelefone.setText("");
                    btnRegistar.setEnabled(true);

                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnRegistar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(876, 620));

        jLabel1.setText("* Nome:");

        jLabel2.setText("Endereço:");

        jLabel3.setText("* Telefone:");

        jLabel4.setText("Email:");

        btnRegistar.setText("Registar");
        btnRegistar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jLabel5.setText("* Campos Obrigatórios");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel6.setText("Pesquisar Nome:");

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idcliente", "nome", "endereço", "telefone", "email"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        jLabel7.setText("id:");

        txtID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefone)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApagar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnRegistar))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnApagar, btnEditar, btnRegistar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnApagar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnEditar)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(29, 29, 29))
        );

        setBounds(0, 0, 876, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        // TODO add your handling code here:
        registarClientes();
    }//GEN-LAST:event_btnRegistarActionPerformed

    // O evento abaixo é do tipo enquanto digitar mostrar em tempo real o resultado
    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisarClientes();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        // TODO add your handling code here:
        preencherCampos();
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        actualizarDados();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
        removerCliente();
    }//GEN-LAST:event_btnApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
