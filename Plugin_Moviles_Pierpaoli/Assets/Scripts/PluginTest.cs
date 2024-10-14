using TMPro;
using UnityEngine;

public class PluginTest : MonoBehaviour
{
    public TextMeshProUGUI label;
    const string pluginClassname = "com.pierpaoli.pierpaolilogger.PierpaoliLoggerManager";

#if UNITY_ANDROID

    AndroidJavaClass pluginClass;
    AndroidJavaObject pluginInstance;
#endif
    void Start()
    {
        label.text = "Start 7";

        Debug.Log("Unity - " + pluginClassname);

#if UNITY_ANDROID
        pluginClass = new AndroidJavaClass(pluginClassname);

        if (pluginClass == null)
        {
            Debug.LogError("pluginClass is null! Check your class name or .aar setup.");
        }
        else
        {
            Debug.Log("pluginClass created successfully.");
        }

        pluginInstance = pluginClass.CallStatic<AndroidJavaObject>("getInstance");
#endif
    }

    public void SendLog()
    {
        Debug.Log("Unity -  SendLog");
#if UNITY_ANDROID
        pluginInstance.Call("SendLog", Time.time.ToString());
#endif
    }

    public void UpdateLogs()
    {
        Debug.Log("Unity -  UpdateLogs");
#if UNITY_ANDROID
        label.text = pluginInstance.Call<string>("GetLogs");
#endif
    }
}