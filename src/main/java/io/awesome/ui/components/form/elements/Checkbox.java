package io.awesome.ui.components.form.elements;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.function.ValueProvider;
import io.awesome.ui.annotations.FormElement;
import io.awesome.ui.binder.ExtendedBinder;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Checkbox<T> extends AbstractHasValueFormElement<T, Boolean> {

    public Checkbox(FormLayout parentForm, ExtendedBinder<T> binder, T entity, Map<String, FormLayout.FormItem> items) {
        super(parentForm, binder, entity, items);
    }

    @Override
    protected HasValue<?, Boolean> buildField(FormElement annotation, String fieldName) {
        var checkbox = new com.vaadin.flow.component.checkbox.Checkbox();
        checkbox.setWidthFull();
        return checkbox;
    }


    @Override
    protected Setter<T, Boolean> bindingSetter(String fieldName) {
        return (t, value) -> util.invokeSetter(
                entity, fieldName, Objects.requireNonNullElse(value, false));
    }
}
