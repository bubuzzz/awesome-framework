package io.awesome.ui.annotations;

import com.vaadin.flow.component.grid.ColumnTextAlign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface GridColumn {
  int columnOrder() default 0;

  boolean autoWidth() default true;

  int flexGrow() default 1;

  String header() default "";

  boolean sortable() default false;

  boolean frozen() default false;

  ColumnTextAlign textAlign() default ColumnTextAlign.START;

  boolean selectable() default false;
}
