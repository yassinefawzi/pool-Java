public class Monster extends Character {
	public Monster(String name, int maxHealth, Weapon weapon) {
		super(name, maxHealth, weapon);
	}

	@Override
	public String toString() {
		String str = (getCurrentHealth() > 0)
			? getName() + " is a monster with " + getCurrentHealth() + " HP"
			: getName() + " is a monster and is dead";
		if (getWeapon() != null)
			str += ". He has the weapon " + getWeapon().toString() + ".";
		return str;

	}

	@Override
	public void attack(Character character) {
		int dmg = (getWeapon() != null) ? getWeapon().getDamage() : 7;
		character.takeDamage(dmg);
	}

	@Override
	public void takeDamage(int damage) {
		int reduced = (int) (damage * 0.8);
		receiveHeals(-reduced);
	}
}
