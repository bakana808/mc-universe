package com.octopod.networkplus.network.lilypad;

import com.octopod.networkplus.NetworkPlusListener;
import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;

/**
 * @author Octopod - octopodsquad@gmail.com
 */
public class LilypadListener
{
	@EventListener
	public void messageReceived(MessageEvent event)
	{
		String channel = event.getChannel(), serverID, message;
//            if(!channel.startsWith(NetworkConfig.getChannelPrefix())) {
//                return;
//            }
		try {
			serverID = event.getSender();
			message = event.getMessageAsString();
		} catch (UnsupportedEncodingException e) {
			return;
		}

		NetworkPlusListener.onRecieveMessage(serverID, channel, message);
//            try {
//                NetworkMessage serverMessage = NetworkMessage.parse(message);
//
//            } catch (JsonParseException e) {
//                //The message probably isn't even a JSON, just ignore it.
//            }

	}
}
