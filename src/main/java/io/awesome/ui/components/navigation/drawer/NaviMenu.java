package io.awesome.ui.components.navigation.drawer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.VaadinIcon;
import io.awesome.context.ContextWrapper;

import java.util.List;
import java.util.stream.Collectors;

@CssImport("./styles/components/navi-menu.css")
public class NaviMenu extends Nav {

  private final String CLASS_NAME = "navi-menu";
  private final UnorderedList list;

  public NaviMenu() {
    setClassName(CLASS_NAME);
    list = new UnorderedList();
    add(list);
  }

  protected void addNaviItem(NaviItem item) {
    list.add(item);
  }

  protected void addNaviItem(NaviItem parent, NaviItem item) {
    parent.addSubItem(item);
    addNaviItem(item);
  }

  public void filter(String filter) {
    getNaviItems()
        .forEach(
            naviItem -> {
              boolean matches = naviItem.getText().toLowerCase().contains(filter.toLowerCase());
              naviItem.setVisible(matches);
            });
  }

  public NaviItem addNaviItem(String text, Class<? extends Component> navigationTarget) {
    NaviItem item = new NaviItem(text, navigationTarget);
    addNaviItem(item);
    return item;
  }

  public NaviItem addNaviItem(
      VaadinIcon icon, String text, Class<? extends Component> navigationTarget) {
    NaviItem item = new NaviItem(icon, text, navigationTarget);
    addNaviItem(item);
    return item;
  }

  public NaviItem addNaviItem(
      Image image, String text, Class<? extends Component> navigationTarget) {
    NaviItem item = new NaviItem(image, text, navigationTarget);
    addNaviItem(item);
    return item;
  }

  public void addNaviItem(
      NaviItem parent, String text, Class<? extends Component> navigationTarget) {
    if (ContextWrapper.getContext().getSecurity().checkForRoleAccess(navigationTarget)) {
      NaviItem item = new NaviItem(text, navigationTarget);
      addNaviItem(parent, item);
    }
  }

  public List<NaviItem> getNaviItems() {
    List items = list.getChildren().collect(Collectors.toList());
    return items;
  }
}
