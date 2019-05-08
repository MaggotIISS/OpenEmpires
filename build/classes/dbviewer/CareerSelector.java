/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer;import java.awt.Component;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JButton;import javax.swing.JComboBox;import panels.Panel4Careers;import panels.Panel4LabelComboButton;/** @author maggot.iiss */public class CareerSelector implements java.awt.event.ActionListener {  /**   NOT USED   */  public static void start() {    //change();  }//  private static void change() {//    String UPP = "777777";//    String Mod = "+1 INT";//    Debug.debug("UPP = " + UXP.changeStats(Mod,UPP));//  }  private final Panel4Careers p4c;  /**   @param outer ?   */  public CareerSelector(final Panel4Careers outer) {    this.p4c = outer;  }  /**   @return name of class   */  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }  /**   @param arg0 ActionEvent   */  @Override  public void actionPerformed(ActionEvent arg0) {    Panel4Careers.Career = Panel4Careers.jbox.getSelectedItem().toString();    selectCareer(Panel4Careers.Career);    CareerGen.enable(0, 3, true);  }  /**   @param career string of career   */  @SuppressWarnings({"unchecked"})  public void selectCareer(String career) {    Panel4Careers.Career = career.toUpperCase();    //<editor-fold defaultstate="collapsed" desc="switch(Career)">    switch (Panel4Careers.Career) {      case "NAVY":        Panel4Careers.Careernum = Panel4Careers.NAVY;        Panel4Careers.ranks = Panel4Careers.navyrank;        Panel4Careers.musters = Panel4Careers.navymuster;        Panel4Careers.cashs = Panel4Careers.navycash;        Panel4Careers.personals = Panel4Careers.navypersonal;        Panel4Careers.services = Panel4Careers.navyservice;        Panel4Careers.educations = Panel4Careers.navyeducation;        Panel4Careers.advanceds = Panel4Careers.navyadvanced;        break;      case "MARINE":        Panel4Careers.Careernum = Panel4Careers.MARINE;        Panel4Careers.ranks = Panel4Careers.marinerank;        Panel4Careers.musters = Panel4Careers.marinemuster;        Panel4Careers.cashs = Panel4Careers.marinecash;        Panel4Careers.personals = Panel4Careers.marinepersonal;        Panel4Careers.services = Panel4Careers.marineservice;        Panel4Careers.Educations = Panel4Careers.marineeducation;        Panel4Careers.Advanceds = Panel4Careers.marineadvanced;        break;      case "ARMY":        Panel4Careers.Careernum = Panel4Careers.ARMY;        Panel4Careers.ranks = Panel4Careers.armyrank;        Panel4Careers.musters = Panel4Careers.armymuster;        Panel4Careers.cashs = Panel4Careers.armycash;        Panel4Careers.personals = Panel4Careers.armypersonal;        Panel4Careers.services = Panel4Careers.armyservice;        Panel4Careers.educations = Panel4Careers.armyeducation;        Panel4Careers.advanceds = Panel4Careers.armyadvanced;        break;      case "SCOUT":        Panel4Careers.Careernum = Panel4Careers.SCOUT;        Panel4Careers.ranks = Panel4Careers.norank;        Panel4Careers.musters = Panel4Careers.scoutmuster;        Panel4Careers.cashs = Panel4Careers.scoutcash;        Panel4Careers.personals = Panel4Careers.scoutpersonal;        Panel4Careers.services = Panel4Careers.scoutservice;        Panel4Careers.educations = Panel4Careers.scouteducation;        Panel4Careers.advanceds = Panel4Careers.scoutadvanced;        break;      case "MERCHANT":        Panel4Careers.Careernum = Panel4Careers.MERCHANT;        Panel4Careers.ranks = Panel4Careers.merchantrank;        Panel4Careers.musters = Panel4Careers.merchantmuster;        Panel4Careers.cashs = Panel4Careers.merchantcash;        Panel4Careers.personals = Panel4Careers.merchantpersonal;        Panel4Careers.services = Panel4Careers.merchantservice;        Panel4Careers.educations = Panel4Careers.merchanteducation;        Panel4Careers.advanceds = Panel4Careers.merchantadvanced;        break;      case "OTHER":        Panel4Careers.Careernum = Panel4Careers.OTHER;        Panel4Careers.ranks = Panel4Careers.norank;        Panel4Careers.musters = Panel4Careers.othermuster;        Panel4Careers.cashs = Panel4Careers.othercash;        Panel4Careers.personals = Panel4Careers.otherpersonal;        Panel4Careers.services = Panel4Careers.otherservice;        Panel4Careers.educations = Panel4Careers.othereducation;        Panel4Careers.advanceds = Panel4Careers.otheradvanced;        break;    }    //</editor-fold>    //<editor-fold defaultstate="collapsed" desc="PC Setup variables">    Panel4Careers.Enlist = Panel4Careers.enlist[Panel4Careers.Careernum];    Panel4Careers.EnlistPlus = Panel4Careers.enlistplus[Panel4Careers.Careernum];    Panel4Careers.EnlistPlusPlus      = Panel4Careers.enlistplusplus[Panel4Careers.Careernum];    Panel4Careers.Draft = Panel4Careers.draft[Panel4Careers.Careernum];    Panel4Careers.Survival = Panel4Careers.survival[Panel4Careers.Careernum];    Panel4Careers.SurvivalPlusPlus      = Panel4Careers.survivalplusplus[Panel4Careers.Careernum];    Panel4Careers.Commission = Panel4Careers.commission[Panel4Careers.Careernum];    Panel4Careers.CommissionPlus      = Panel4Careers.commissionplus[Panel4Careers.Careernum];    Panel4Careers.Promotion = Panel4Careers.promotion[Panel4Careers.Careernum];    Panel4Careers.PromotionPlus      = Panel4Careers.promotionplus[Panel4Careers.Careernum];    Panel4Careers.Reenlist = Panel4Careers.reenlist[Panel4Careers.Careernum];    Panel4Careers.Ranks = Panel4Careers.ranks;    Panel4Careers.Musters = Panel4Careers.musters;    Panel4Careers.Cashs = Panel4Careers.cashs;    Panel4Careers.Personals = Panel4Careers.personals;    Panel4Careers.Service = career;    Panel4Careers.Educations = Panel4Careers.educations;    Panel4Careers.Advanceds = Panel4Careers.advanceds;    //</editor-fold>    final Component[] comps = new Component[Panel4LabelComboButton.getJpan()      .getComponentCount()];    int j;    JComboBox<String> jcb;    int count = 0;    int labels = 0;    int combos = 0;    int buttons = 0;    for (int i = 0; i < comps.length; i++) {      comps[i] = Panel4LabelComboButton.getJpan().getComponent(i);      //<editor-fold defaultstate="collapsed" desc="JLabel">      if (comps[i].toString().contains("JLabel")) {        labels += 1;      } else //</editor-fold>      //<editor-fold defaultstate="collapsed" desc="JComboBox">       if (comps[i].toString().contains("JComboBox")) {          combos += 1;          jcb = (JComboBox) comps[i];          jcb.removeAllItems();          //<editor-fold defaultstate="collapsed" desc="Combo Items">          switch (comps[i].getName()) {            case "Enlist":              jcb.addItem(Panel4Careers.Enlist);              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Enlist DM+1":              jcb.addItem(Panel4Careers.EnlistPlus);              jcb.addItem("Stat Increase");              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Enlist DM+2":              jcb.addItem(Panel4Careers.EnlistPlusPlus);              jcb.addItem("Stat Increase");              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Draft":              jcb.addItem(Panel4Careers.Draft);              break;            case "Survival":              jcb.addItem(Panel4Careers.Survival);              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Survival DM+2":              jcb.addItem(Panel4Careers.SurvivalPlusPlus);              jcb.addItem("Stat Increase");              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Commission":              jcb.addItem(Panel4Careers.Commission);              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Commission DM+1":              jcb.addItem(Panel4Careers.CommissionPlus);              jcb.addItem("Stat Increase");              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Promotion":              jcb.addItem(Panel4Careers.Promotion);              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Promotion DM+1":              jcb.addItem(Panel4Careers.PromotionPlus);              jcb.addItem("Stat Increase");              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Reenlist":              jcb.addItem(Panel4Careers.Reenlist);              jcb.addItem("Pass");              jcb.addItem("Fail");              break;            case "Rank":              jcb.addItem("");              for (j = 0; j < Panel4Careers.Ranks.length; j++) {                jcb.addItem(Panel4Careers.ranks[j]);              }              break;            case "Muster":              jcb.addItem("");              for (j = 0; j < Panel4Careers.musters.length; j++) {                jcb.addItem(Panel4Careers.musters[j]);              }              break;            case "Cash":              jcb.addItem("");              for (j = 0; j < Panel4Careers.cashs.length; j++) {                jcb.addItem(Panel4Careers.cashs[j]);              }              break;            case "Personal":              jcb.addItem("");              for (j = 0; j < Panel4Careers.Personals.length; j++) {                jcb.addItem(Panel4Careers.Personals[j]);              }              break;            case "Service":              jcb.addItem("");              for (j = 0; j < Panel4Careers.services.length; j++) {                jcb.addItem(Panel4Careers.services[j]);              }              break;            case "Education":              jcb.addItem("");              for (j = 0; j < Panel4Careers.Educations.length; j++) {                jcb.addItem(Panel4Careers.Educations[j]);              }              break;            case "Advanced":              jcb.addItem("");              for (j = 0; j < Panel4Careers.Advanceds.length; j++) {                jcb.addItem(Panel4Careers.Advanceds[j]);              }              break;          }          //</editor-fold>          if (combos > 1) {            jcb.setEnabled(true);          }        } else //</editor-fold>        //<editor-fold defaultstate="collapsed" desc="JButton">         if (comps[i].toString().contains("JButton")) {            buttons += 1;            final JButton jb;            jb = (JButton) comps[i];            jb.addActionListener(new ActionListener() {              @Override              public void actionPerformed(ActionEvent arg0) {                int total;                int req;                int roll;                Debug.debug(" ======================== " + jb.getName());                switch (jb.getName()) {                  //<editor-fold defaultstate="collapsed" desc="Draft & Modifiers">                  case "Draft":                    roll = 0 + CareerGen.rollDice(1, 6);                    Debug.debug("Draft roll = " + roll + " = "                      + Panel4Careers.careers[roll - 1]);                    Panel4Careers.terms = 1;                    break;                  case "Enlist DM+1":                    CareerGen.calcModifiers(4);                    break;                  case "Enlist DM+2":                    CareerGen.calcModifiers(7);                    break;                  case "Survival DM+2":                    CareerGen.calcModifiers(16);                    break;                  case "Commission DM+1":                    CareerGen.calcModifiers(22);                    break;                  case "Promotion DM+1":                    CareerGen.calcModifiers(28);                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Enlist">                  case "Enlist":                    roll = 0 + CareerGen.rollDice(2, 6);                    int dm = 0 + Integer.parseInt(CareerGen.checkScores(                      Panel4Careers.p4lcb.getSelectedItemFromCombo(4).toString(),                      4));                    dm += Integer.parseInt(CareerGen.checkScores(                      Panel4Careers.p4lcb.getSelectedItemFromCombo(7).toString(),                      7));                    Debug.debug("roll = " + roll + " Plus " + dm + " = " + (roll                      + dm));                    total = (roll + dm);                    req = Integer.parseInt(Panel4Careers.p4lcb.getItemFromCombo(                      1, 0));                    //assert(total>req);//--------------------------------------                    if (total >= req) {                      Debug.debug("Enlist pass");                      CareerGen.employed();                      CareerGen.enable(0, 54, false);                      CareerGen.enable(12, 15, true);//survival                    } else if (total < req) {                      Debug.debug("Enlist fail, roll Draft");                      CareerGen.enable(0, 54, false);                      CareerGen.enable(9, 12, true);//draft                    } else {                      Debug.debug("ERROR IN ENLIST");                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Survival">                  case "Survival":                    roll = 0 + CareerGen.rollDice(2, 6);                    dm = 0 + Integer.parseInt(CareerGen.checkScores(                      Panel4Careers.p4lcb.getSelectedItemFromCombo(16)                      .toString(), 16));                    Debug.debug("roll = " + roll + " Plus " + dm + " = " + (roll                      + dm));                    total = (roll + dm);                    req = Integer.parseInt(Panel4Careers.p4lcb.getItemFromCombo(                      13, 0));                    //assert(total>req);//--------------------------------------                    if (total >= req) {                      Debug.debug("Survival pass");                      if (("SCOUT".equals(Panel4Careers.Career)) | ("OTHER"                        .equals(Panel4Careers.Career))) {                        Debug.debug("SCOUT OR OTHER");                        CareerGen.enable(0, 54, false);                        CareerGen.enable(30, 33, true);                      }                      if ((!"SCOUT".equals(Panel4Careers.Career)) & (!"OTHER"                        .equals(Panel4Careers.Career))) {                        Debug.debug("NOT SCOUT OR OTHER");                        Debug.debug("term = " + Panel4Careers.terms);                        if (Panel4Careers.terms == 1) {                          Debug.debug("1st term");                          CareerGen.enable(0, 54, false);                          CareerGen.enable(30, 33, true);                        } else if ((Panel4Careers.terms > 1)                          & (Panel4Careers.commissioned == 0)) {                          Debug.debug("uncommissioned in term "                            + Panel4Careers.terms);                          CareerGen.enable(0, 54, false);                          CareerGen.enable(18, 21, true);                        } else if ((Panel4Careers.terms > 1)                          & (Panel4Careers.commissioned != 0)) {                          Debug.debug("commissioned in term"                            + Panel4Careers.commissioned);                          CareerGen.enable(0, 54, false);                          CareerGen.enable(24, 27, true);                        }                      }                    }                    if (total < req) {                      CareerGen.enable(0, 54, false);                      CareerGen.enable(33, 54, true);                      Debug.debug("Survival fail");                      CareerGen.mustered();                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Commission">                  case "Commission":                    roll = 0 + CareerGen.rollDice(2, 6);                    dm = 0 + Integer.parseInt(CareerGen.checkScores(                      Panel4Careers.p4lcb.getSelectedItemFromCombo(22)                      .toString(), 22));                    Debug.debug("roll = " + roll + " Plus " + dm + " = " + (roll                      + dm));                    total = (roll + dm);                    req = Integer.parseInt(Panel4Careers.p4lcb.getItemFromCombo(                      19, 0));                    //assert(total>req);//--------------------------------------                    if (total >= req) {                      if (Panel4Careers.terms > 1) {                        if (Panel4Careers.commissioned == 0) {                          Panel4Careers.commissioned = Panel4Careers.terms;                          Debug.debug("commissioned in term "                            + Panel4Careers.commissioned);                          CareerGen.promoted();                          Panel4Careers.updateName();                          CareerGen.enable(0, 54, false);                        }                        if ((Panel4Careers.terms > Panel4Careers.commissioned)                          & (Panel4Careers.commissioned != 0)) {                          CareerGen.enable(24, 27, true);                        } else {                          CareerGen.enable(31, 33, true);                        }                      } else {                        Debug.debug("Not in first term");                        CareerGen.enable(0, 54, false);                        CareerGen.enable(31, 33, true);                      }                    }                    if (total < req) {                      Debug.debug("Commission fail");                      CareerGen.enable(0, 54, false);                      CareerGen.enable(30, 33, true);                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Promotion">                  case "Promotion":                    Debug.debug(" ======================== " + jb.getName());                    roll = 0 + CareerGen.rollDice(2, 6);                    dm = 0 + Integer.parseInt(CareerGen.checkScores(                      Panel4Careers.p4lcb.getSelectedItemFromCombo(28)                      .toString(), 28));                    Debug.debug("roll = " + roll + " Plus " + dm + " = " + (roll                      + dm));                    total = (roll + dm);                    req = Integer.parseInt(Panel4Careers.p4lcb.getItemFromCombo(                      25, 0));                    if ((total >= req) & (Panel4Careers.commissioned                      < Panel4Careers.terms)) {                      Debug.debug("Promotion pass");                      //Panel4Careers.ranknum += 1;                      CareerGen.promoted();                      CareerGen.enable(0, 54, false);                      CareerGen.enable(30, 33, true);                    }                    if (total < req) {                      Debug.debug("Promotion fail");                      CareerGen.enable(0, 54, false);                      CareerGen.enable(30, 33, true);                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Reenlist">                  case "Reenlist": {                    Debug.debug(" ======================== " + jb.getName());                    total = 0 + CareerGen.rollDice(2, 6);                    req = 0 + Integer.parseInt(Panel4Careers.p4lcb                      .getSelectedItemFromCombo(31).toString(), 31);                    if (total >= req) {                      Debug.debug("Reenlist pass");                      Panel4Careers.terms += 1;                      //Debug.debug("Panel4Careers.terms = " +Panel4Careers.terms);                      CareerGen.enable(0, 54, false);                      CareerGen.enable(12, 15, true);                    }                    if (total < req) {                      Debug.debug("Reenlist fail");                      CareerGen.mustered();                    }                    break;                  }                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Rank">                  case "Rank":                    roll = 0 + CareerGen.rollDice(1, 6);                    Debug.debug("Rank roll = " + roll + " = "                      + Panel4Careers.p4lcb.getItemFromCombo(34, roll)                      .toString());                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Muster">                  case "Muster":                    roll = 0 + CareerGen.rollDice(1, 6);                    Debug.debug("Muster roll = " + roll + " = "                      + Panel4Careers.p4lcb.getItemFromCombo(37, roll)                      .toString());                    Panel4Careers.p4lcb.setSelectedInCombo(37, roll);                    Panel4Careers.musterlist.add(Panel4Careers.p4lcb                      .getItemFromCombo(37, roll).toString());                    Panel4Careers.mustersgained -= 1;                    if (Panel4Careers.mustersgained < 1) {                      CareerGen.enable(36, 42, false);                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="Cash">                  case "Cash":                    roll = 0 + CareerGen.rollDice(1, 6);                    Debug.debug("Cash roll = " + roll + " = KCr"                      + Panel4Careers.p4lcb.getItemFromCombo(40, roll)                      .toString());                    Panel4Careers.p4lcb.setSelectedInCombo(40, roll);                    //Panel4Careers.Cash+=Integer.parseInt(Panel4Careers.p4lcb.setSelectedInCombo(40, roll).substring(0,Panel4Careers.p4lcb.setSelectedInCombo(40, roll).length()-4));                    int cash = Integer.parseInt(Panel4Careers.p4lcb                      .setSelectedInCombo(40, roll).substring(0,                      Panel4Careers.p4lcb.setSelectedInCombo(40, roll).length()                      - 4));                    Debug.debug("cash = " + cash);//                int pre = Integer.parseInt(Panel4Careers.Cash.substring(0,Panel4Careers.Cash.length()));//                Panel4Careers.Cash = ""+(cash+pre);                    Panel4Careers.musterlist.add(Panel4Careers.p4lcb                      .getItemFromCombo(40, roll).toString());                    Panel4Careers.mustersgained -= 1;                    if (Panel4Careers.mustersgained < 1) {                      CareerGen.enable(36, 42, false);                    }                    break;                  //</editor-fold>                  //<editor-fold defaultstate="collapsed" desc="SkillGain">                  case "Personal":                    CareerGen.skillGain("Personal", 43);                    break;                  case "Service":                    CareerGen.skillGain("Service", 46);                    break;                  case "Education":                    CareerGen.skillGain("Education", 49);                    break;                  case "Advanced":                    CareerGen.skillGain("Advanced", 52);                    break;                  //</editor-fold>                }                Debug.debug(                  " ========================  ======================== ");              }            });            if (buttons > 1) {              jb.setEnabled(false);            }          }      //</editor-fold>    }    DBViewer.setTitle(Panel4Careers.updateName());    Debug.debug(Panel4Careers.updateName());    ////System.out.print("" + " = " + Panel4Careers.p4lcb.getSelectedItemFromCombo(2));    CareerGen.enable(2, 2, true);  }}