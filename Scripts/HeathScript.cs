using UnityEngine;
using System.Collections;

public class HeathScript : MonoBehaviour {
	public int health = 3;
	public bool isEnemy1 = false;
	public bool isEnemy2 = false;

	// Use this for initialization
	void Start () {

	}
	
	// Update is called once per frame
	void Update () {
	
	}

	void Damage(int dmgCount) {
		if (health > 0) {
			health -= dmgCount;
		} if (health == 0){
			Destroy (gameObject);
		}
	}
	
	void OnTriggerEnter2D (Collider2D collider){
		ProjectileScript bullet = collider.gameObject.GetComponent<ProjectileScript>();
		if (bullet != null) {
			Damage(bullet.dmg);
		}
		Destroy (bullet.gameObject);

	}
}
