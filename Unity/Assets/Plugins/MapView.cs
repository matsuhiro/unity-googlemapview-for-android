using UnityEngine;
using System.Collections;

public class MapView : MonoBehaviour
{
	public bool locationTest = false;

	[HideInInspector]
	public float latitude;
	[HideInInspector]
	public float longitude;
	
	
	[HideInInspector]
	public bool flag = false;
	
	private AndroidJavaObject activity;
	void Start ()
	{
		AndroidJavaClass unityPlayer = new AndroidJavaClass ("com.unity3d.player.UnityPlayer");
		activity = unityPlayer.GetStatic<AndroidJavaObject> ("currentActivity");
	}
	
	public void SetLocation(){
		if(flag)
			return;
		
		flag = true;
		StartCoroutine(_SetLocation());
	}
	
	private IEnumerator _SetLocation ()
	{
		iPhoneSettings.StartLocationServiceUpdates ();
		while (iPhoneSettings.locationServiceStatus.Equals (LocationServiceStatus.Initializing)) {
			yield return new WaitForEndOfFrame ();
		}
		latitude = iPhoneInput.lastLocation.latitude;
		longitude = iPhoneInput.lastLocation.longitude;
		activity.Call ("setLocation", latitude, longitude);
		iPhoneSettings.StopLocationServiceUpdates ();
		
		flag = false;
	}

	public void SetLocationTest (float latitude, float longitude)
	{
		activity.Call ("setLocation", latitude, longitude);
	}
}
