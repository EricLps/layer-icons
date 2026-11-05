package org.ericlps;

import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LayerIconProvider extends IconProvider {

    private static final Icon CLASS_ICON = IconLoader.getIcon("/icons/class.svg", LayerIconProvider.class);

    private static final Icon INTERFACE_ICON = IconLoader.getIcon("/icons/interface.svg", LayerIconProvider.class);

    private static final Icon ENUM_ICON = IconLoader.getIcon("/icons/enum.svg", LayerIconProvider.class);

    private static final Icon RECORD_ICON = IconLoader.getIcon("/icons/record.svg", LayerIconProvider.class);

    @Override
    public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {

        if (element instanceof PsiClass psiClass) {

            if (psiClass.isEnum()) {

                return ENUM_ICON;

            } else if (psiClass.isInterface()) {

                return INTERFACE_ICON;

            } else if (psiClass.isRecord()) {

                return RECORD_ICON;

            } else {

                return CLASS_ICON;

            }

        }

        return null;

    }

}
