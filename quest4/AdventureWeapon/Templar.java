public class Templar extends Character implements Healer, Tank {
	private final int healCapacity;
	private final int shield;

	public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
		super(name, maxHealth, weapon);
		this.healCapacity = healCapacity;
		this.shield = shield;
	}

	@Override
	public int getHealCapacity() {
		return healCapacity;
	}

	@Override
	public void heal(Character character) {
		character.receiveHeals(healCapacity);
	}

	@Override
	public int getShield() {
		return shield;
	}

	@Override
	public void attack(Character character) {
		heal(this);
		int damage = (getWeapon() != null) ? getWeapon().getDamage() : 6;
		character.takeDamage(damage);
	}

	@Override
	public void takeDamage(int damage) {
		int templarDamage = damage - shield;
		if (templarDamage < 0) {
			templarDamage = 0;
		}
		receiveHeals(-templarDamage);
	}

	@Override
	public String toString() {
		String str;
		if (getCurrentHealth() == 0) {
			str = getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP.";
		} else {
			str = getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
		}
		if (getWeapon() != null)
			str += " He has the weapon " + getWeapon().toString() + ".";
		return str;
	}

}
