using UnityEngine;
using System.Collections;

public class Sample : MonoBehaviour
{
	private MapView mapView;

	public GUISkin skin;
	void Start ()
	{
		mapView = GetComponent<MapView> ();
	}

	void Update ()
	{
		if (Input.touches.Length == 3 && !mapView.locationTest)
			mapView.locationTest = true;
		
		
		if (Input.touchCount != 0  && !mapView.locationTest) {
			mapView.SetLocation ();
		}
	}


	/* GUI */

	void OnGUI ()
	{
		GUI.skin = skin;
		
		if (mapView.locationTest)
			LocationTest ();
		else {
			GUILayout.BeginArea (new Rect (0, Screen.height / 2 - 100, Screen.width, 200));
			GUILayout.Label ("Please touch the screen");
			GUILayout.Box ("latitude : " + mapView.latitude);
			GUILayout.Box ("longitude : " + mapView.longitude);
			GUILayout.Label ("Test mode by tap with three fingers");
			GUILayout.EndArea ();
		}
	}

	private void LocationTest ()
	{
		GUILayout.Space (10);
		if (GUILayout.Button ("Back"))
			mapView.locationTest = false;
		
		GUILayout.BeginArea (new Rect (20, Screen.height / 2 - 85, Screen.width - 20, Screen.height - 40));
		GUILayout.Label ("Test Mode");
		GUILayout.BeginHorizontal ();
		LocationTestButton ("Okinawa", 26.212358f, 127.680874f);
		LocationTestButton ("Fukuoka", 33.590421f, 130.401664f);
		GUILayout.EndHorizontal ();
		GUILayout.BeginHorizontal ();
		LocationTestButton ("Osaka", 34.69378f, 135.501938f);
		LocationTestButton ("Tokyo", 35.689579f, 139.691763f);
		GUILayout.EndHorizontal ();
		GUILayout.BeginHorizontal ();
		LocationTestButton ("Hokkaido", 43.064373f, 141.346922f);
		LocationTestButton ("UnityTechnologies", 37.797965f, -122.402954f);
		GUILayout.EndHorizontal ();
		GUILayout.EndArea ();
	}

	private void LocationTestButton (string locationName, float latitude, float longitude)
	{
		if (GUILayout.Button (locationName, GUILayout.Width (Screen.width / 2 - 20), GUILayout.Height (50)))
			mapView.SetLocationTest (latitude, longitude);
	}
}
