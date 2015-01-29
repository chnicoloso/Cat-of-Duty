using UnityEngine;
using System.Collections;

public class Timer : MonoBehaviour {
	
	int timer;
	public GUIText seconds;
	// Use this for initialization
	void Start() 
	{
		seconds = GetComponent<GUIText>();
	 	timer = 120;
		StartCoroutine(WaitAndPrint(1f));
	
	}
	
	// Update is called once per frame
	/*void Update () 
	{




	}
*/

	IEnumerator WaitAndPrint(float waitTime) 
	{
		while (timer > 0)
		{
		yield return new WaitForSeconds(waitTime);
		print("WaitAndPrint " + Time.time);
		timer -= 1;
		seconds.text = timer.ToString();
		}
	}
}
