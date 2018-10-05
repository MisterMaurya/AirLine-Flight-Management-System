package com.airlines.util;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;

public class ComboBoxUI {
	public static JComboBox comboUI(JComboBox list){
		
		list.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					private static final long serialVersionUID = 1L;

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						// scroller.setBorder(BorderFactory.createEmptyBorder());
						scroller.setViewportBorder(new LineBorder(new Color(229, 243, 251)));

						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									private static final long serialVersionUID = 1L;

									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		return list;
		
	}

}
