/*
 * Copyleft (C) 2015 Piotr Siatkowski find me on Facebook;
 * This file is part of BotMaker. BotMaker is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version. BotMaker is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU General Public License for more details. You should have received a
 * copy of the GNU General Public License along with BotMaker (look at the
 * Documents directory); if not, either write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA, or visit
 * (http://www.gnu.org/licenses/gpl.txt).
 */

package com.thetruthbeyond.gui.action.emitters;

import com.thetruthbeyond.gui.action.Emitter;
import com.thetruthbeyond.gui.action.EventEmitter;

public class OnChangeVisibility extends Emitter {
	
	// Id functionality.
	public static int Id; @Override public int getId() { return Id; }
			
	private boolean isVisible = false;
		
	public OnChangeVisibility(EventEmitter owner) {
		super(owner);
	}
		
	public void setVisible(boolean visible) {
		boolean wasVisibilityChanged = (isVisible != visible);

		isVisible = visible;
		if(wasVisibilityChanged)
			signalEvent();
	}
		
	public boolean isVisible() {
		return isVisible;
	}
}
