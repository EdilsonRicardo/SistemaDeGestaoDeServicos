/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Edilson Ricardo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        menuRelatorio.setVisible(false);
        menuCadastroUsuario.setVisible(false);
        //As linhas abaixo substituem a label DATA "lblData", pela data actual do sistema ao inicializar o form
        //Poderia ter colocado este dado no metodo "formWindowActivated"
        Date data = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formato.format(data));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroCliente = new javax.swing.JMenuItem();
        menuCadastroOS = new javax.swing.JMenuItem();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuRelatorioServicos = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjudaSobre = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setText("Data");

        menuCadastro.setText("Cadastro  |");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        menuCadastroCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroCliente.setText("Cliente");
        menuCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroCliente);

        menuCadastroOS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroOS.setText("OS");
        menuCadastro.add(menuCadastroOS);

        menuCadastroUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroUsuario.setText("Usuário");
        menuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroUsuario);

        menu.add(menuCadastro);

        menuRelatorio.setText("Relatório  |");

        menuRelatorioServicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuRelatorioServicos.setText("Serviços");
        menuRelatorio.add(menuRelatorioServicos);

        menu.add(menuRelatorio);

        menuAjuda.setText("Ajuda  |");

        menuAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuAjudaSobre.setText("Sobre");
        menuAjuda.add(menuAjudaSobre);

        menu.add(menuAjuda);

        menuOpcoes.setText("Opções");

        menuOpcoesSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuOpcoesSair.setText("Sair");
        menuOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesSair);

        menu.add(menuOpcoes);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(13, 13, 13)))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addContainerGap(480, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1127, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesSairActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuOpcoesSairActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowActivated

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
        // TODO add your handling code here:
        TelaCadUsuario telaUsuario = new TelaCadUsuario();
        telaUsuario.setVisible(true);
        desktop.add(telaUsuario);
    }//GEN-LAST:event_menuCadastroUsuarioActionPerformed

    private void menuCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroClienteActionPerformed
        // TODO add your handling code here:
        TelaCadCliente tCliente = new TelaCadCliente();
        tCliente.setVisible(true);
        desktop.add(tCliente);
    }//GEN-LAST:event_menuCadastroClienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuAjudaSobre;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCliente;
    private javax.swing.JMenuItem menuCadastroOS;
    public static javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOpcoesSair;
    public static javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioServicos;
    // End of variables declaration//GEN-END:variables
}
