plugins {
    id("java")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
}

dependencies {
    intellijPlatform {
        intellijIdea("2025.3.6.1")
        bundledPlugin("com.intellij.java")
    }
}
