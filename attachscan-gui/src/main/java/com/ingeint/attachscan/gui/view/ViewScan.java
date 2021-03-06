/**
 * This file is part of Attach Scan.
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p>
 * Copyright (C) 2015 INGEINT <http://www.ingeint.com>.
 * Copyright (C) Contributors.
 * <p>
 * Contributors:
 * - 2015 Saúl Piña <spina@ingeint.com>.
 */

package com.ingeint.attachscan.gui.view;

import com.ingeint.attachscan.gui.component.SaneDeviceWrap;
import com.ingeint.attachscan.gui.controller.ControllerScan;
import com.ingeint.attachscan.gui.feature.ASUIFeature;
import com.ingeint.attachscan.gui.feature.ASUILocale;
import com.ingeint.attachscan.gui.feature.ASUIStandard;
import com.ingeint.attachscan.gui.util.JIntegerField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewScan extends JFrame {

    private static final long serialVersionUID = -852528628596429017L;

    private List<JButton> buttons;
    private List<JMenuItem> menuItems;
    private JMenuBar mnuBar;
    private JMenu mnuOptions;
    private JMenu mnuHelp;
    private JMenu mnuLocale;
    private JMenuItem mniClose;
    private JMenuItem mniAbout;
    private JMenuItem mniDocumentation;
    private JPanel noPanel;
    private JLabel lblHost;
    private JTextField txtHost;
    private JButton btnSearch;
    private JLabel lblDevice;
    private JComboBox<SaneDeviceWrap> cmbDevice;
    private JButton btnScan;
    private DefaultComboBoxModel<SaneDeviceWrap> cmbDeviceModel;
    private JLabel lblPort;
    private JIntegerField txtPort;
    private JLabel lblResolution;
    private JIntegerField txtResolution;
    private JCheckBox cbDuplex;

    public ViewScan() {
        setSize(530, 200);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(ASUIStandard.ICON);
        setLayout(new BorderLayout());
        setTitle(String.format("%s - %s", ASUIFeature.get("APP_NAME"), ASUILocale.get("ViewScan.title")));
        buttons = new ArrayList<JButton>();
        menuItems = new ArrayList<JMenuItem>();

        // MENU BAR
        mnuBar = new JMenuBar();
        setJMenuBar(mnuBar);

        mnuOptions = new JMenu();
        mnuHelp = new JMenu();
        mnuBar.add(mnuOptions);
        mnuBar.add(mnuHelp);

        mnuLocale = new JMenu();
        mniClose = new JMenuItem();
        mnuOptions.add(mnuLocale);
        mnuOptions.add(mniClose);

        mniDocumentation = new JMenuItem();
        mniAbout = new JMenuItem();
        mnuHelp.add(mniDocumentation);
        mnuHelp.add(mniAbout);

        menuItems.add(mniDocumentation);
        menuItems.add(mniAbout);
        menuItems.add(mniClose);

        // NORTH PANEL
        noPanel = new JPanel();
        noPanel.setLayout(new MigLayout());

        lblHost = new JLabel();
        txtHost = new JTextField();
        lblPort = new JLabel();
        txtPort = new JIntegerField();
        btnSearch = new JButton();

        lblDevice = new JLabel();
        cmbDevice = new JComboBox<SaneDeviceWrap>();
        cmbDeviceModel = new DefaultComboBoxModel<SaneDeviceWrap>();
        cmbDevice.setModel(cmbDeviceModel);
        btnScan = new JButton();

        lblResolution = new JLabel();
        txtResolution = new JIntegerField();

        cbDuplex = new JCheckBox();

        buttons.add(btnScan);
        buttons.add(btnSearch);

        noPanel.add(lblHost, "width 60, height 26");
        noPanel.add(txtHost, "width 200, height 26");
        noPanel.add(lblPort, "width 40, height 26");
        noPanel.add(txtPort, "width 80, height 26");
        noPanel.add(btnSearch, "width 60, height 26, wrap");
        noPanel.add(lblDevice, "grow, height 26");
        noPanel.add(cmbDevice, "growx, span 3, height 26");
        noPanel.add(btnScan, "growx, height 26, wrap");
        noPanel.add(lblResolution, "width 40, height 26");
        noPanel.add(txtResolution, "width 80, height 26");
        noPanel.add(cbDuplex, "growx, height 26");
        add(noPanel, BorderLayout.NORTH);
    }

    public void addListener(ControllerScan listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }

        for (JMenuItem menuItem : menuItems) {
            menuItem.addActionListener(listener);
        }

        addWindowListener(listener);
    }

    public JMenu getMnuOptions() {
        return mnuOptions;
    }

    public JMenu getMnuHelp() {
        return mnuHelp;
    }

    public JMenuItem getMnuLocale() {
        return mnuLocale;
    }

    public JMenuItem getMniClose() {
        return mniClose;
    }

    public JMenuItem getMniAbout() {
        return mniAbout;
    }

    public JLabel getLblHost() {
        return lblHost;
    }

    public JTextField getTxtHost() {
        return txtHost;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JComboBox<SaneDeviceWrap> getCmbDevice() {
        return cmbDevice;
    }

    public JButton getBtnScan() {
        return btnScan;
    }

    public DefaultComboBoxModel<SaneDeviceWrap> getCmbDeviceModel() {
        return cmbDeviceModel;
    }

    public JLabel getLblDevice() {
        return lblDevice;
    }

    public List<JButton> getButtons() {
        return buttons;
    }

    public List<JMenuItem> getMenuItems() {
        return menuItems;
    }

    public JLabel getLblPort() {
        return lblPort;
    }

    public JIntegerField getTxtPort() {
        return txtPort;
    }

    public JMenuItem getMniDocumentation() {
        return mniDocumentation;
    }

    public JLabel getLblResolution() {
        return lblResolution;
    }

    public JIntegerField getTxtResolution() {
        return txtResolution;
    }

    public JCheckBox getCbDuplex() {
        return cbDuplex;
    }
}
