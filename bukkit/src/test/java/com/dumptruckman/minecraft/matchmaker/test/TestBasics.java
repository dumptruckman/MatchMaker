/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.dumptruckman.minecraft.matchmaker.test;

import com.dumptruckman.minecraft.matchmaker.api.config.MatchConfig;
import com.dumptruckman.minecraft.pluginbase.config.BaseConfig;
import com.dumptruckman.minecraft.matchmaker.MatchMakerPlugin;
import com.dumptruckman.minecraft.matchmaker.test.utils.TestInstanceCreator;
import com.dumptruckman.minecraft.pluginbase.plugin.AbstractBukkitPlugin;
import junit.framework.Assert;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.util.Locale;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MatchMakerPlugin.class, AbstractBukkitPlugin.class})
public class TestBasics {
    TestInstanceCreator creator;
    Server mockServer;
    CommandSender mockCommandSender;

    @Before
    public void setUp() throws Exception {
        creator = new TestInstanceCreator();
        assertTrue(creator.setUp());
        mockServer = creator.getServer();
        mockCommandSender = creator.getCommandSender();
    }

    @After
    public void tearDown() throws Exception {
        creator.tearDown();
    }

    @Test
    public void testEnableDebugMode() {
        // Pull a core instance from the server.
        Plugin plugin = mockServer.getPluginManager().getPlugin("MatchMaker");
        MatchMakerPlugin myPlugin = (MatchMakerPlugin) plugin;

        // Make sure Core is not null
        assertNotNull(plugin);

        // Make sure Core is enabled
        assertTrue(plugin.isEnabled());

        // Make a fake server folder to fool MV into thinking a world folder exists.
        File serverDirectory = new File(creator.getPlugin().getServerFolder(), "world");
        serverDirectory.mkdirs();

        // Initialize a fake command
        Command mockCommand = mock(Command.class);
        when(mockCommand.getName()).thenReturn("mm");

        // Assert debug mode is off
        Assert.assertEquals(0, (int) myPlugin.config().get(BaseConfig.DEBUG_MODE));

        // Send the debug command.
        String[] cmdArgs = new String[] { "debug", "3" };
        myPlugin.onCommand(mockCommandSender, mockCommand, "", cmdArgs);

        cmdArgs = new String[] { "reload" };
        myPlugin.onCommand(mockCommandSender, mockCommand, "", cmdArgs);

        Assert.assertEquals(3, (int) myPlugin.config().get(BaseConfig.DEBUG_MODE));

        Assert.assertEquals(BaseConfig.LOCALE.serialize(BaseConfig.LOCALE.getDefault()).toString(), myPlugin.config().get(BaseConfig.LOCALE).toString());
        
        myPlugin.config().set(BaseConfig.LOCALE, Locale.CANADA);

        Assert.assertEquals(Locale.CANADA, myPlugin.config().get(BaseConfig.LOCALE));
        
        myPlugin.config().save();
        
        boolean throwsException = false;
        try {
            myPlugin.config().get(MatchConfig.MAX_LIVES);
        } catch (IllegalArgumentException ignore) {
            throwsException = true;
        }
        Assert.assertTrue(throwsException);

        cmdArgs = new String[] {  };
        plugin.onCommand(mockCommandSender, mockCommand, "", cmdArgs);

        cmdArgs = new String[] { "help" };
        plugin.onCommand(mockCommandSender, mockCommand, "", cmdArgs);

        cmdArgs = new String[] { "create", "arena", "poop" };
        plugin.onCommand(mockCommandSender, mockCommand, "", cmdArgs);
    }
}
