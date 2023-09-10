package javamap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import marqueur.MonMarqueur;
import marqueur.MarqueurpointRender;
import marqueur.EventMarqueur;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Carte extends javax.swing.JFrame {
    
    DefaultTableModel model; 
    ArrayList<Mapping> locations;
    public Carte() {
        locations=Controller.GetAllGeo();
        initComponents();
        //Initialisation de la carte
        remplirTable();
        //
        
        //
        init();
        // Ajouter un marqueur
        //Coordonnées de l'université Constantine 2: 
        //ajouterMarqueur("Université Constantine 2", 36.244482835883964, 6.570153236280022);
        
        
    }
    
    void remplirTable() {
        model = new DefaultTableModel();//pour etre capable traiter le tablaux et ajouter et selectiones les elements
        Object[] colomun = {"emplacement" , "longitude" , "latitude" , "tempurature" , "Taux de remplissage"};
        Object[] row = new Object[5];
        model.setColumnIdentifiers(colomun);
        jTable1.setModel(model);

            
        
        //on utulisant cette boucle pour navuiger enter le resultat et insere-les dans notre table
        for (Mapping location : locations){
            // Printing the elements of ArrayList
            row[0] = location.getEmp();
            row[1] = location.getLat();
            row[2] = location.getLon();
            row[3] = location.getTemp();
            row[4] = location.getTaux();
            model.addRow(row);
//         for(int j=0;j<jTable1.getRowCount();j++){
//           
//                ajouterMarqueur(model.getValueAt(j, 0).toString(),Double.parseDouble(model.getValueAt(j, 2).toString()),Double.parseDouble(model.getValueAt(j, 1).toString()));
//            ;
//       }
    }

    }
    
    void ajouterMarqueur(String emplacement, double laltitude, double longitude) {
        MonMarqueur wp = new MonMarqueur(emplacement, event, new GeoPosition(laltitude, longitude));
        marqueurs.add(wp);
        //Redessiner la carte
        initMarqueur();
    }
    
    void ajouterMarqueurBleu(String emplacement, double laltitude, double longitude) {
        MonMarqueur wp = new MonMarqueur(emplacement, event, new GeoPosition(laltitude, longitude));
        wp.getButton().setIcon(new ImageIcon(getClass().getResource("/icon/pinSelect.png")));
        marqueurs.add(wp);
        
        //Redessiner la carte
        initMarqueur();
    }
    
    void ajouterMarqueurRouge(String emplacement, double laltitude, double longitude) {
        MonMarqueur wp = new MonMarqueur(emplacement, event, new GeoPosition(laltitude, longitude));
        wp.getButton().setIcon(new ImageIcon(getClass().getResource("/icon/pin.png")));
        
        marqueurs.add(wp);
        //Redessiner la carte
        initMarqueur();
    }
    
    void supprimerTousMarqueurs() {
        //Parcourir la liste des marqueurs et les supprimer l'un après l'autre
        for (MonMarqueur d : marqueurs) {
            jXMapViewer.remove(d.getButton());
        }
        marqueurs.clear();
        //Redessiner la carte
        initMarqueur();
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        comboMapType = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        ZoomMoins = new javax.swing.JButton();
        ZoomPlus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        barchart = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jXMapViewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboMapType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open Stree", "Virtual Earth", "Hybrid", "Satellite" }));
        comboMapType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
        );

        ZoomMoins.setText("Zoom -");
        ZoomMoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomMoinsActionPerformed(evt);
            }
        });

        ZoomPlus.setText("Zoom +");
        ZoomPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomPlusActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Eplacement", "Laltitude", "Longitude", "tempurature", "Taux De Remplissage"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Longitude");

        jLabel3.setText("Laltitude");

        jLabel1.setText("Epmlacement");

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ZoomPlus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZoomMoins))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ZoomPlus)
                    .addComponent(ZoomMoins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Map", jPanel1);

        barchart.setLayout(new java.awt.BorderLayout());

        label1.setText("Please Select The Chart Type To Show Analytics ");
        barchart.add(label1, java.awt.BorderLayout.CENTER);

        button1.setLabel("BarChart");
        button1.setName("BarChart"); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("PieChart");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barchart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 261, Short.MAX_VALUE))
        );

        //BarChart x = new BarChart();
        //                JFreeChart bar = BarChart.createChart(x.createDataset(locations));
        //
        //                barchart.add(new ChartPanel(bar));

        jTabbedPane1.addTab("Analytics", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(36.244482835883964, 6.570153236280022);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(10);
        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        event = getEvent();
        
    }
    
    private void initMarqueur() {
        WaypointPainter<MonMarqueur> wp = new MarqueurpointRender();
        wp.setWaypoints(marqueurs);
        jXMapViewer.setOverlayPainter(wp);
        for (MonMarqueur d : marqueurs) {
            jXMapViewer.add(d.getButton());
        }
    }
    private void comboMapTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapTypeActionPerformed
        TileFactoryInfo info;
        int index = comboMapType.getSelectedIndex();
        if (index == 0) {
            info = new OSMTileFactoryInfo();
        } else if (index == 1) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        } else if (index == 2) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
        } else {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
        }
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
    }//GEN-LAST:event_comboMapTypeActionPerformed

    private void ZoomPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomPlusActionPerformed
        jXMapViewer.setZoom(jXMapViewer.getZoom() - 1);
    }//GEN-LAST:event_ZoomPlusActionPerformed

    private void ZoomMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomMoinsActionPerformed
        jXMapViewer.setZoom(jXMapViewer.getZoom() + 1);
    }//GEN-LAST:event_ZoomMoinsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Ajouter un emplacement
        String emplacement = jTextField1.getText();
        String laltitude = jTextField2.getText();
        String longitude = jTextField3.getText();
        Controller.AddGeo(new Mapping(emplacement, Double.parseDouble(longitude) ,Double.parseDouble(laltitude)));
        model.setNumRows(0);
        remplirTable();

    }//GEN-LAST:event_jButton1ActionPerformed
     private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
         
          int i = jTable1.getSelectedRow();
           JOptionPane.showMessageDialog(null, "Information:\n Name :"+model.getValueAt(i, 0).toString()+"\n GeoPosition:"+model.getValueAt(i, 1).toString()+" , "+model.getValueAt(i, 2).toString()+"\n Tempurature :" + model.getValueAt(i, 3).toString()+"\n Taux De Remplissage :"+model.getValueAt(i, 4).toString());
          
                    int n = marqueurs.size();
                    MonMarqueur temp[] = new MonMarqueur[n];
                    temp = marqueurs.toArray(temp);
          if(!marqueurs.isEmpty()){
                if(CheckSet(marqueurs , model.getValueAt(i, 0).toString())){
                    supprimerTousMarqueurs() ;

                    for( MonMarqueur s : temp){
                        if(s.getName().equalsIgnoreCase(model.getValueAt(i, 0).toString())){
                           ajouterMarqueurBleu(s.getName(),s.getPosition().getLatitude(),s.getPosition().getLongitude());                      
                        }else{
                            ajouterMarqueurRouge(s.getName(),s.getPosition().getLatitude(),s.getPosition().getLongitude());
                            
                        }
                    }

                }else{
                    
                     supprimerTousMarqueurs() ;
                    for( MonMarqueur s : temp){
                            ajouterMarqueurRouge(s.getName(),s.getPosition().getLatitude(),s.getPosition().getLongitude());
                            
                        }
                        ajouterMarqueurBleu(model.getValueAt(i, 0).toString(),Double.parseDouble(model.getValueAt(i, 2).toString()),Double.parseDouble(model.getValueAt(i, 1).toString()));
                    }

                
          }else{
              ajouterMarqueurBleu(model.getValueAt(i, 0).toString(),Double.parseDouble(model.getValueAt(i, 2).toString()),Double.parseDouble(model.getValueAt(i, 1).toString()));
               
     }
          

            
       
    }//GEN-LAST:event_jTable1MouseReleased

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
                // TODO add your handling code here:
                barchart.removeAll();
                BarChart x = new BarChart();
                JFreeChart bar = BarChart.createChart(x.createDataset(locations));
                
                barchart.add(new ChartPanel(bar));
                barchart.revalidate();
                barchart.repaint();

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        barchart.removeAll();
        JFreeChart pie = PieChart.createChart(PieChart.createDataset(locations));
                
        barchart.add(new ChartPanel(pie));
         barchart.revalidate();
                barchart.repaint();
    }//GEN-LAST:event_button2ActionPerformed
    private EventMarqueur getEvent() {
        return new EventMarqueur() {
            @Override
            public void selected(MonMarqueur waypoint) {
                waypoint.getButton().setToolTipText(waypoint.getName());
                
//                 
            }
                                               
        };
    }
   
    private boolean CheckSet( Set<MonMarqueur> x , String emp){
        boolean i = false;
        for(MonMarqueur y : x){
            if(y.getName().equalsIgnoreCase(emp)){
            i = true;
            }
        }
       return i;
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    //Pour contenir les marqueurs
    private Set<MonMarqueur> marqueurs = new HashSet<>();
    private EventMarqueur event;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ZoomMoins;
    private javax.swing.JButton ZoomPlus;
    private javax.swing.JPanel barchart;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox<String> comboMapType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
