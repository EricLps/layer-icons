package org.ericlps;

import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.InheritanceUtil;
import com.intellij.ui.LayeredIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class LayerIconProvider extends IconProvider {

    //ICONES BASE
    private static final Icon CLASS_ICON = IconLoader.getIcon("/icons/class.svg", LayerIconProvider.class);

    private static final Icon INTERFACE_ICON = IconLoader.getIcon("/icons/interface.svg", LayerIconProvider.class);

    private static final Icon ENUM_ICON = IconLoader.getIcon("/icons/enum.svg", LayerIconProvider.class);

    private static final Icon RECORD_ICON = IconLoader.getIcon("/icons/record.svg", LayerIconProvider.class);

    private static final Icon ANNOTATION_ICON = IconLoader.getIcon("/icons/annotation.svg", LayerIconProvider.class);

    private static final Icon EXCEPTION_ICON = IconLoader.getIcon("/icons/exception.svg", LayerIconProvider.class);

//    ==================================================================================================================================

    // BADGES DOS ICONES
    private static final Icon REPOSITORY_BADGE = IconLoader.getIcon("/icons/badge-repository.svg", LayerIconProvider.class);

    private static final Icon ENTITY_BADGE = IconLoader.getIcon("/icons/badge-entity.svg", LayerIconProvider.class);

    private static final Icon CONFIG_BADGE = IconLoader.getIcon("/icons/badge-config.svg", LayerIconProvider.class);

    private static final Icon CONTROLLER_BADGE = IconLoader.getIcon("/icons/badge-controller.svg", LayerIconProvider.class);

    private static final Icon DTO_BADGE = IconLoader.getIcon("/icons/badge-dto.svg", LayerIconProvider.class);

    private static final Icon EDITOR_BADGE = IconLoader.getIcon("/icons/badge-editor.svg", LayerIconProvider.class);

    private static final Icon RESOURCES_BADGE = IconLoader.getIcon("/icons/badge-resources.svg", LayerIconProvider.class);

    private static final Icon SERVICE_BADGE = IconLoader.getIcon("/icons/badge-service.svg", LayerIconProvider.class);

    private static final Icon SRC_BADGE = IconLoader.getIcon("/icons/badge-src.svg", LayerIconProvider.class);

    private static final Icon TEST_BADGE = IconLoader.getIcon("/icons/badge-test.svg", LayerIconProvider.class);

    private static final Icon EXCEPTION_BADGE = IconLoader.getIcon("/icons/badge-exception.svg", LayerIconProvider.class);

    private static final Map<String, Icon> SELO_POR_SUFIXO = Map.of(
            "Repository",    REPOSITORY_BADGE,
            "Service",       SERVICE_BADGE,
            "Controller",    CONTROLLER_BADGE,
            "Dto",           DTO_BADGE,
            "DTO",           DTO_BADGE,
            "Entity",        ENTITY_BADGE,
            "Model",         ENTITY_BADGE,
            "Config",        CONFIG_BADGE,
            "Configuration", CONFIG_BADGE,
            "Test",          TEST_BADGE
    );

    // ================================================================================================================================================================================================================

    //Icones de pastas

    private static final Icon FOLDER_ICON =
            IconLoader.getIcon("/icons/folder.svg", LayerIconProvider.class);

    private static final Map<String, Icon> SELO_POR_PASTA = Map.ofEntries(
            Map.entry("src",        SRC_BADGE),
            Map.entry("resources",  RESOURCES_BADGE),
            Map.entry(".idea",      EDITOR_BADGE),
            Map.entry(".vscode",    EDITOR_BADGE),
            Map.entry("controller", CONTROLLER_BADGE),
            Map.entry("service",    SERVICE_BADGE),
            Map.entry("repository", REPOSITORY_BADGE),
            Map.entry("dto",        DTO_BADGE),
            Map.entry("entity",     ENTITY_BADGE),
            Map.entry("model",      ENTITY_BADGE),
            Map.entry("config",     CONFIG_BADGE),
            Map.entry("test",       TEST_BADGE),
            Map.entry("exception", EXCEPTION_BADGE),
            Map.entry("exceptions",EXCEPTION_BADGE)
    );

    private static final Icon GRADLE_ICON = IconLoader.getIcon("/icons/file-gradle.svg", LayerIconProvider.class);

    private static final Icon MAVEN_ICON = IconLoader.getIcon("/icons/file-maven.svg", LayerIconProvider.class);

    private static final Icon BAT_ICON = IconLoader.getIcon("/icons/file-bat.svg", LayerIconProvider.class);

    private static final Icon MARKDOWN_ICON = IconLoader.getIcon("/icons/file-markdown.svg", LayerIconProvider.class);

    private static final Icon GITIGNORE_ICON = IconLoader.getIcon("/icons/file-gitignore.svg", LayerIconProvider.class);

    private static final Map<String, Icon> ICONE_POR_ARQUIVO = Map.ofEntries(
            Map.entry("build.gradle",              GRADLE_ICON),
            Map.entry("build.gradle.kts",          GRADLE_ICON),
            Map.entry("settings.gradle",           GRADLE_ICON),
            Map.entry("settings.gradle.kts",       GRADLE_ICON),
            Map.entry("gradle.properties",         GRADLE_ICON),
            Map.entry("gradle-wrapper.properties", GRADLE_ICON),
            Map.entry("gradlew",                   GRADLE_ICON),
            Map.entry("gradlew.bat",               GRADLE_ICON),
            Map.entry("pom.xml",                   MAVEN_ICON),
            Map.entry("mvnw",                      MAVEN_ICON),
            Map.entry("mvnw.cmd",                  MAVEN_ICON),
            Map.entry("maven-wrapper.properties",  MAVEN_ICON),
            Map.entry(".gitignore",                GITIGNORE_ICON)
    );

    private static final Map<String, Icon> ICONE_POR_EXTENSAO = Map.ofEntries(
            Map.entry("bat", BAT_ICON),
            Map.entry("cmd", BAT_ICON),
            Map.entry("md", MARKDOWN_ICON),
            Map.entry("markdown", MARKDOWN_ICON)
    );

    @Override
    public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {

        if (element instanceof PsiClass psiClass) {
            return iconeDeClasse(psiClass);
        }

        if (element instanceof PsiDirectory pasta) {
            return iconeDePasta(pasta);
        }

        if (element instanceof PsiFile arquivo) {
            return iconeDeArquivo(arquivo);
        }

        return null;
    }

    private Icon iconeDeClasse(PsiClass psiClass) {
        Icon base;

        if (psiClass.isEnum()) {

            base = ENUM_ICON;

        } else if (psiClass.isAnnotationType()) {

            base = ANNOTATION_ICON;

        } else if (psiClass.isInterface()) {

            base = INTERFACE_ICON;

        } else if (InheritanceUtil.isInheritor(psiClass, "java.lang.Throwable")) {

            base = EXCEPTION_ICON;

        } else if (psiClass.isRecord()) {

            base = RECORD_ICON;

        } else {

            base = CLASS_ICON;

        }

        String nome = psiClass.getName();
        if (nome == null) {
            return base;
        }
        for (Map.Entry<String, Icon> par : SELO_POR_SUFIXO.entrySet()) {
            if (nome.endsWith(par.getKey())) {
                return new LayeredIcon(base, par.getValue());
            }
        }
        return base;
    }


    private @Nullable Icon iconeDePasta(PsiDirectory pasta) {
        Icon selo = SELO_POR_PASTA.get(pasta.getName().toLowerCase());
        if (selo == null) {
            return FOLDER_ICON;
        }
        return new LayeredIcon(FOLDER_ICON, selo);
    }

    private @Nullable Icon iconeDeArquivo(PsiFile arquivo) {
        String nome = arquivo.getName().toLowerCase();

        Icon icone = ICONE_POR_ARQUIVO.get(nome);
        if (icone != null) {
            return icone;
        }

        int ponto = nome.lastIndexOf('.');
        if (ponto < 0) {
            return null;
        }
        return ICONE_POR_EXTENSAO.get(nome.substring(ponto + 1));
    }

}
