/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import agenda.telefonica.NrTel;
import agenda.telefonica.NrFix;
import agenda.telefonica.NrMobil;
import Interfata.AdaugareAbonat;
import bazadedate.Conectare;
import static bazadedate.Conectare.verifyConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import bazadedate.Interogari;
import javax.swing.JButton;
import Interfata.CarteDeTelefonActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import sun.util.resources.sr.CurrencyNames_sr_Latn_ME;

/**
 *
 * @author Stan
 */
public class CarteDeTelefon extends javax.swing.JFrame {

    /**
     * Creates new form Fereastra
     */ 
    
    OrdonareAbonat o = new OrdonareAbonat();
    private final ActionListenerFactory actionListenerFactory;
    private int randSelectat = 0;
    public List<Abonat> lista_abonati = extrageDinBazadeDate();
    
   
    //elementele folosite pentru a realiza reclama
    Timer tm;
    int x = 0;
    ImageIcon reclama1 = new ImageIcon(getClass().getResource("r1.jpg"));
    ImageIcon reclama2 = new ImageIcon(getClass().getResource("r2.jpg"));
    ImageIcon reclama3 = new ImageIcon(getClass().getResource("r3.jpg"));
    ImageIcon reclama4 = new ImageIcon(getClass().getResource("r4.jpg"));
    ImageIcon reclame[] = {reclama1, reclama2, reclama3, reclama4};

    public void setareImagine(ImageIcon i){
        Image img = i.getImage();
        Image newImg = img.getScaledInstance(lReclame.getWidth(), lReclame.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon newImc = new ImageIcon(newImg);
        lReclame.setIcon(newImc);
    }
    
    //constructorul CarteDeTelefon care instantiaza un obiect de tip ActionListener
    //folosirea obiectului de tip timer pentru a creea slideshow-ul de reclame 
      public CarteDeTelefon() {
        initComponents();     
        actionListenerFactory = new ActionListenerFactory(this);
        tm = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareImagine(reclame[x]);
                x += 1;
                if(x >= reclame.length-1){
                    x=0;
                }
                //afiseaza_tabela(extrageDinBazadeDate());
            }
        });
        add(lReclame);
        tm.start();
    }
       
    //getter pentru obiectul actionListenerFactory
    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }
    
    //metoda prin care se extrage din baza de date si returneaza o lista cu abonatii
    public ArrayList<Abonat> extrageDinBazadeDate(){      
            ArrayList<agenda.telefonica.Abonat> lista_abonati = new ArrayList<>();
            agenda.telefonica.Abonat abonat;
            
            try {
                Connection c = verifyConnection();
                String query1 = "Select * FROM agenda";
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query1);  

                while(rs.next()){
                    String nume = rs.getString("nume");
                    String prenume = rs.getString("prenume");
                    String CNP = rs.getString("CNP");
                    String nrFix = rs.getString("Numar_Fix");
                    String nrMobil = rs.getString("Numar_Mobil");
                    abonat = new Abonat(nume, prenume, CNP, nrFix, nrMobil);
                    lista_abonati.add(abonat);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            return lista_abonati;
    }
    
    //metoda prin care se populeaza tabela, primind ca parametru o lista de abonati
    public void afiseaza_tabela(List lista_abonati){
        refreshTabela();
        List<Abonat> list = lista_abonati;
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.fireTableDataChanged();
        //tabela.setAutoCreateRowSorter(true);
        Object[] row = new Object[5];
        
        for(int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getNume();
            row[1] = list.get(i).getPrenume();
            row[2] = list.get(i).getCNP();
            row[3] = list.get(i).getNrFix();
            row[4] = list.get(i).getNrMobil();
            model.addRow(row);
        }
    }
   
    public void refreshTabela(){
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        model.setRowCount(0);
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        bGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        butoanePrincipale = new javax.swing.JPanel();
        bAdauga = new javax.swing.JButton();
        bStergere = new javax.swing.JButton();
        bRefreshTabela = new javax.swing.JButton();
        tCautare = new javax.swing.JTextField();
        bCautare = new javax.swing.JButton();
        interfataEditare = new javax.swing.JPanel();
        tNume = new javax.swing.JTextField();
        bEditare = new javax.swing.JButton();
        tPrenume = new javax.swing.JTextField();
        tCNP = new javax.swing.JTextField();
        tNumarMobil = new javax.swing.JTextField();
        lNume = new javax.swing.JLabel();
        lPrenume = new javax.swing.JLabel();
        lCNP = new javax.swing.JLabel();
        lTelefonMobil = new javax.swing.JLabel();
        tNumarFix = new javax.swing.JTextField();
        lTelefonFix = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        lUser = new javax.swing.JLabel();
        tUser = new javax.swing.JTextField();
        lParola = new javax.swing.JLabel();
        bLogare = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        bIesire = new javax.swing.JButton();
        tParola = new javax.swing.JPasswordField();
        pOrdonare = new javax.swing.JPanel();
        rNume = new javax.swing.JRadioButton();
        rPrenume = new javax.swing.JRadioButton();
        rCNP = new javax.swing.JRadioButton();
        rTelefonFix = new javax.swing.JRadioButton();
        rTelefonMobil = new javax.swing.JRadioButton();
        lReclame = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Inregistrare = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume", "Prenume", "CNP", "Numar Fix", "Numar Mobil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        bAdauga.setText("Adauga");
        bAdauga.setEnabled(false);
        bAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });

        bStergere.setText("Stergere");
        bStergere.setEnabled(false);
        bStergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergereActionPerformed(evt);
            }
        });

        bRefreshTabela.setText("Refresh tabela");
        bRefreshTabela.setEnabled(false);
        bRefreshTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshTabelaActionPerformed(evt);
            }
        });

        bCautare.setText("Cautare");
        bCautare.setEnabled(false);
        //bCautare.addActionListener(getActionListenerFactory().getCautaAbonat());
        bCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCautareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout butoanePrincipaleLayout = new javax.swing.GroupLayout(butoanePrincipale);
        butoanePrincipale.setLayout(butoanePrincipaleLayout);
        butoanePrincipaleLayout.setHorizontalGroup(
            butoanePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butoanePrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAdauga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStergere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefreshTabela)
                .addGap(161, 161, 161)
                .addComponent(tCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        butoanePrincipaleLayout.setVerticalGroup(
            butoanePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butoanePrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(butoanePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(butoanePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tCautare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCautare))
                    .addGroup(butoanePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAdauga)
                        .addComponent(bStergere)
                        .addComponent(bRefreshTabela)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bEditare.setText("Editare");
        bEditare.setToolTipText("");
        bEditare.setEnabled(false);
        bEditare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditareActionPerformed(evt);
            }
        });

        lNume.setText("Nume");

        lPrenume.setText("Prenume");

        lCNP.setText("CNP");

        lTelefonMobil.setText("Telefon Mobil");

        lTelefonFix.setText("Telefon Fix");

        javax.swing.GroupLayout interfataEditareLayout = new javax.swing.GroupLayout(interfataEditare);
        interfataEditare.setLayout(interfataEditareLayout);
        interfataEditareLayout.setHorizontalGroup(
            interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfataEditareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lPrenume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lCNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTelefonMobil, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lTelefonFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tNumarMobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(tNumarFix, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tPrenume)
                    .addComponent(tCNP)
                    .addComponent(tNume))
                .addGap(18, 18, 18)
                .addComponent(bEditare)
                .addGap(13, 13, 13))
        );
        interfataEditareLayout.setVerticalGroup(
            interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfataEditareLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNume)
                    .addComponent(tNume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPrenume))
                .addGap(2, 2, 2)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCNP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEditare))
                .addGap(6, 6, 6)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNumarMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTelefonMobil, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(interfataEditareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNumarFix)
                    .addComponent(lTelefonFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lUser.setText("User");

        lParola.setText("Parola");

        bLogare.setText("Log in");
        bLogare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogareActionPerformed(evt);
            }
        });

        bRefresh.setText("Refresh");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });

        bIesire.setText("Iesire");
        bIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIesireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(bRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bLogare, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(bIesire, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lParola, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tUser, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tParola, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUser)
                    .addComponent(tUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lParola)
                    .addComponent(tParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLogare)
                    .addComponent(bRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bIesire)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        loginPanel.setVisible(false);

        bGroup.add(rNume);
        rNume.setText("Nume");
        rNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNumeActionPerformed(evt);
            }
        });

        bGroup.add(rPrenume);
        rPrenume.setText("Prenume");
        rPrenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPrenumeActionPerformed(evt);
            }
        });

        bGroup.add(rCNP);
        rCNP.setText("CNP");
        rCNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCNPActionPerformed(evt);
            }
        });

        bGroup.add(rTelefonFix);
        rTelefonFix.setActionCommand("Numar fix");
        rTelefonFix.setLabel("Numar fix");
        rTelefonFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTelefonFixActionPerformed(evt);
            }
        });

        bGroup.add(rTelefonMobil);
        rTelefonMobil.setActionCommand("Numar fix");
        rTelefonMobil.setLabel("Numar mobil");
        rTelefonMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTelefonMobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pOrdonareLayout = new javax.swing.GroupLayout(pOrdonare);
        pOrdonare.setLayout(pOrdonareLayout);
        pOrdonareLayout.setHorizontalGroup(
            pOrdonareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOrdonareLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rTelefonMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pOrdonareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOrdonareLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pOrdonareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rNume)
                        .addComponent(rPrenume)
                        .addComponent(rCNP)
                        .addComponent(rTelefonFix, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE)))
        );
        pOrdonareLayout.setVerticalGroup(
            pOrdonareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOrdonareLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(rTelefonMobil))
            .addGroup(pOrdonareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOrdonareLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(rNume)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rPrenume)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rCNP)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rTelefonFix)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        File.setText("File");

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        MenuBar.add(File);

        Help.setText("Help");

        Inregistrare.setText("Inregistrare");
        Inregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InregistrareActionPerformed(evt);
            }
        });
        Help.add(Inregistrare);

        MenuBar.add(Help);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(interfataEditare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(butoanePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(pOrdonare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addComponent(lReclame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butoanePrincipale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(interfataEditare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pOrdonare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lReclame, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1019, 813));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void bAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaActionPerformed
        new Interfata.AdaugareAbonat().setVisible(true);
    }//GEN-LAST:event_bAdaugaActionPerformed

    private void InregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InregistrareActionPerformed
      loginPanel.setVisible(true);
    }//GEN-LAST:event_InregistrareActionPerformed

    private void bStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStergereActionPerformed
        getActionListenerFactory().getStergeAbonat().stergeAbonat();
        afiseaza_tabela(extrageDinBazadeDate());
    }//GEN-LAST:event_bStergereActionPerformed

    private void bRefreshTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshTabelaActionPerformed
        refreshTabela();
        afiseaza_tabela(extrageDinBazadeDate());
    }//GEN-LAST:event_bRefreshTabelaActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    //metoda prin care se seteaza valoarea in JtextField-uri la apasarea unui rand in tabela
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        int i = tabela.getSelectedRow();
        TableModel model = tabela.getModel();
        String nume = tabela.getModel().getValueAt(i, 0).toString();
        String prenume = tabela.getModel().getValueAt(i, 1).toString();
        String CNP = tabela.getModel().getValueAt(i, 2).toString();
        String numar_fix = tabela.getModel().getValueAt(i, 3).toString();
        String numar_mobil = tabela.getModel().getValueAt(i, 4).toString();
        tNume.setText(nume);
        tPrenume.setText(prenume);
        tCNP.setText(CNP);
        tNumarFix.setText(numar_fix);
        tNumarMobil.setText(numar_mobil);
    }//GEN-LAST:event_tabelaMouseClicked

    private void bEditareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditareActionPerformed
        getActionListenerFactory().getEditareAbonat().editareAbonat();
    }//GEN-LAST:event_bEditareActionPerformed

    private void bLogareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogareActionPerformed
        getActionListenerFactory().getLoginAbonat().loginAbonat();
    }//GEN-LAST:event_bLogareActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        tUser.setText("");
        tParola.setText("");
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIesireActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bIesireActionPerformed

    private void rNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNumeActionPerformed
        lista_abonati = o.ordoneaza(OrdonareAbonat.CriteriuOrdonare.DUPA_NUME);
        refreshTabela();
        afiseaza_tabela(lista_abonati);
    }//GEN-LAST:event_rNumeActionPerformed

    private void rPrenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPrenumeActionPerformed
        lista_abonati = o.ordoneaza(OrdonareAbonat.CriteriuOrdonare.DUPA_PRENUME);
        afiseaza_tabela(lista_abonati);
    }//GEN-LAST:event_rPrenumeActionPerformed

    private void rCNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCNPActionPerformed
        lista_abonati = o.ordoneaza(OrdonareAbonat.CriteriuOrdonare.DUPA_CNP);
        afiseaza_tabela(lista_abonati);
    }//GEN-LAST:event_rCNPActionPerformed

    private void rTelefonFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTelefonFixActionPerformed
        lista_abonati = o.ordoneaza(OrdonareAbonat.CriteriuOrdonare.DUPA_FIX);
        afiseaza_tabela(lista_abonati);
    }//GEN-LAST:event_rTelefonFixActionPerformed

    private void rTelefonMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTelefonMobilActionPerformed
        lista_abonati = o.ordoneaza(OrdonareAbonat.CriteriuOrdonare.DUPA_MOBIL);
        afiseaza_tabela(lista_abonati);
    }//GEN-LAST:event_rTelefonMobilActionPerformed

    private void bCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCautareActionPerformed
        getActionListenerFactory().getCautaAbonat().cautareAbonat();
    }//GEN-LAST:event_bCautareActionPerformed

     public JButton getbCautare(){
        return bCautare;
    }
     
    public JTextField gettCautare(){
        return tCautare;
    }
    
    public JTextField gettNume(){
        return tNume; 
    }
    
    public JTextField gettPrenume(){
        return tPrenume;
    }
    
    public JTextField gettCNP(){
     return tCNP;   
    }
    
    public JTextField gettNumarMobil(){
        return tNumarMobil;
    }
    
    public JTextField gettNumarFix(){
        return tNumarFix;
    }
    
    public JButton getbEditare() {
        return bEditare;
    }

    public JButton getbStergere() {
        return bStergere;
    }

    public JButton getbActualizare() {
        return bRefreshTabela;
    }

    public JButton getbAdauga() {
        return bAdauga;
    }
    
    public JTextField gettUser(){
        return tUser;
    }
    
    public JTextField gettParola(){
        return tParola;
    }
    
    public JTable getTabela(){
        return tabela;
    }
    
    public JPanel getloginPanel(){
        return loginPanel;
    }
    
    public JTextField getUser(){
        return tUser;
    }
    
    public JTextField getParola(){
        return tParola;
    }
    
    public void setTabela(JTable tabela){
        this.tabela = tabela;
    }
    
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
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
                }
                CarteDeTelefon agenda = new CarteDeTelefon();
                agenda.pack();
                agenda.setVisible(true);
                agenda.setTitle("Agenda Telefonica");
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Inregistrare;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton bAdauga;
    private javax.swing.JButton bCautare;
    private javax.swing.JButton bEditare;
    private javax.swing.ButtonGroup bGroup;
    private javax.swing.JButton bIesire;
    private javax.swing.JButton bLogare;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bRefreshTabela;
    private javax.swing.JButton bStergere;
    private javax.swing.JPanel butoanePrincipale;
    private javax.swing.JPanel interfataEditare;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCNP;
    private javax.swing.JLabel lNume;
    private javax.swing.JLabel lParola;
    private javax.swing.JLabel lPrenume;
    private javax.swing.JLabel lReclame;
    private javax.swing.JLabel lTelefonFix;
    private javax.swing.JLabel lTelefonMobil;
    private javax.swing.JLabel lUser;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel pOrdonare;
    private javax.swing.JRadioButton rCNP;
    private javax.swing.JRadioButton rNume;
    private javax.swing.JRadioButton rPrenume;
    private javax.swing.JRadioButton rTelefonFix;
    private javax.swing.JRadioButton rTelefonMobil;
    private javax.swing.JTextField tCNP;
    private javax.swing.JTextField tCautare;
    private javax.swing.JTextField tNumarFix;
    private javax.swing.JTextField tNumarMobil;
    private javax.swing.JTextField tNume;
    private javax.swing.JPasswordField tParola;
    private javax.swing.JTextField tPrenume;
    private javax.swing.JTextField tUser;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
