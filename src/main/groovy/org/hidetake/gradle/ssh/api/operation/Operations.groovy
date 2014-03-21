package org.hidetake.gradle.ssh.api.operation

import org.hidetake.gradle.ssh.api.Remote
import org.hidetake.gradle.ssh.api.SshSettings
import org.hidetake.gradle.ssh.registry.Registry
import org.hidetake.gradle.ssh.ssh.api.Connection

/**
 * Interface of operations.
 *
 * @author hidetake.org
 */
interface Operations {
    /**
     * A factory of {@link Operations}.
     */
    interface Factory {
        Operations create(Connection connection, SshSettings sshSettings)
    }

    final factory = Registry.instance[Factory]

    Remote getRemote()

    void shell(ShellSettings settings, Closure closure)

    String execute(ExecutionSettings settings, String command, Closure closure)

    String executeSudo(ExecutionSettings settings, String command)

    void executeBackground(ExecutionSettings settings, String command)

    void get(String remote, String local)

    void put(String local, String remote)
}