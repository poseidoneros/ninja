

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityNinjastar extends EntityThrowable
{

	public EntityNinjastar(World par1World) {
		super(par1World);
		
	}
	public EntityNinjastar(World par1World, EntityLiving par2EntityLiving)
	{
		super(par1World, par2EntityLiving);
	}
	public EntityNinjastar(World par1World, double par2, double par4, double par6){
		super(par1World, par2, par4, par6);
	}
	
	
	
	

	@Override
	protected void onImpact(MovingObjectPosition par1movingobjectposition) 
	{
	if (par1movingobjectposition.entityHit != null){
		byte b0 = 3;
		
		par1movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),b0);
	}
		
	for (int i = 0; i < 8; ++i){
		this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
	if (!this.worldObj.isRemote){
		this.setDead();
	}
	
	
	}

	
	
	
	
	
}
