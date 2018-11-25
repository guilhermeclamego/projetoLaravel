package br.com.fatura.bean;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.themeswitcher.ThemeSwitcher;

@ManagedBean(name = "themeSwitcherBean")
@SessionScoped
public class ThemeSwitcherBean implements Serializable {

    private static final long serialVersionUID = 7448888248791054139L;
    private Map<String, String> themes;
    private String theme= "bootstrap";

    public Map<String, String> getThemes() {
       return themes;
    }

    public String getTheme() {
       return theme;
    }

    public void setTheme(String theme) {
       this.theme = theme;
    }

    @PostConstruct
    public void init() {
       themes = new TreeMap<String, String>();
       themes.put("Aristo", "aristo");
       themes.put("Black-Tie", "black-tie");
       themes.put("Blitzer", "blitzer");
       themes.put("Bluesky", "bluesky");
       themes.put("Cruze", "cruze");
       themes.put("Boostrap", "bootstrap");
       themes.put("Casablanca", "casablanca");
       themes.put("Cupertino", "cupertino");
       themes.put("Dark-Hive", "dark-hive");
       themes.put("Dot-Luv", "dot-luv");
       themes.put("Eggplant", "eggplant");
       themes.put("Excite-Bike", "excite-bike");
       themes.put("Flick", "flick");
       themes.put("Glass-X", "glass-x");
       themes.put("Hot-Sneaks", "hot-sneaks");
       themes.put("Humanity", "humanity");
       themes.put("Le-Frog", "le-frog");
       themes.put("Midnight", "midnight");
       themes.put("Mint-Choc", "mint-choc");
       themes.put("Overcast", "overcast");
       themes.put("Pepper-Grinder", "pepper-grinder");
       themes.put("Redmond", "redmond");
       themes.put("Rocket", "rocket");
       themes.put("Sam", "sam");
       themes.put("Smoothness", "smoothness");
       themes.put("South-Street", "south-street");
       themes.put("Start", "start");
       themes.put("Sunny", "sunny");
       themes.put("Swanky-Purse", "swanky-purse");
       themes.put("Trontastic", "trontastic");
       themes.put("UI-Darkness", "ui-darkness");
       themes.put("UI-Lightness", "ui-lightness");
       themes.put("Vader", "vader");
    }

    public void saveTheme(AjaxBehaviorEvent ajax) {
       setTheme((String) ((ThemeSwitcher)ajax.getSource()).getValue());
    }
 }