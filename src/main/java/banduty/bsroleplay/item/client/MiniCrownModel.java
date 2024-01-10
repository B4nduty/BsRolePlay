package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.CrownItem;
import banduty.bsroleplay.item.custom.MiniCrownItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class MiniCrownModel extends GeoModel<MiniCrownItem> {

    @Override
    public Identifier getModelResource(MiniCrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/mini_crown.geo.json");
    }

    @Override
    public Identifier getTextureResource(MiniCrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/mini_crown.png");
    }

    @Override
    public Identifier getAnimationResource(MiniCrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
