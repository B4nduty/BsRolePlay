package banduty.bsroleplay.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.navigation.GuiNavigation;
import net.minecraft.client.gui.navigation.GuiNavigationPath;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class TextureWidget extends ClickableWidget {
    public TextureWidget(int x, int y, int width, int height) {
        super(x, y, width, height, ScreenTexts.EMPTY);
    }

    public static TextureWidget create(int x, int y, int width, int height, Identifier texture, int textureWidth, int textureHeight) {
        return new Texture(x, y, width, height, texture, textureWidth, textureHeight);
    }

    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
    }

    public void playDownSound(SoundManager soundManager) {
    }

    public boolean isNarratable() {
        return false;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {

    }

    @Nullable
    public GuiNavigationPath getNavigationPath(GuiNavigation navigation) {
        return null;
    }

    @Environment(EnvType.CLIENT)
    static class Texture extends TextureWidget {
        private final Identifier texture;
        private final int textureWidth;
        private final int textureHeight;

        public Texture(int x, int y, int width, int height, Identifier texture, int textureWidth, int textureHeight) {
            super(x, y, width, height);
            this.texture = texture;
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
        }

        protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            context.drawTexture(this.texture, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 0.0F, 0.0F, this.getWidth(), this.getHeight(), this.textureWidth, this.textureHeight);
        }
    }
}
