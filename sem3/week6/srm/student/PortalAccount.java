package srm.student;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Demonstrates Section 5: Write-Only Property.
 * A value that must be accepted/updated from the outside, but should NEVER
 * be read back out directly. Password handling is the classic industry example.
 */
public class PortalAccount {
    private String username;
    private String passwordHash;

    public PortalAccount(String username, String initialPassword) {
        this.username = username;
        setPassword(initialPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * WRITE-ONLY PROPERTY:
     * Has a setter, but DELIBERATELY NO getPassword() getter!
     * Callers can set or change the password, but cannot read it back.
     */
    public void setPassword(String plainPassword) {
        if (plainPassword == null || plainPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
        this.passwordHash = hash(plainPassword);
    }

    /**
     * Verification method:
     * Verifies if an entered password matches without ever leaking the internal hash.
     */
    public boolean verifyPassword(String enteredPassword) {
        if (enteredPassword == null) return false;
        return this.passwordHash.equals(hash(enteredPassword));
    }

    // Helper hashing method (private implementation detail)
    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "fallback_hash:" + input.hashCode();
        }
    }

    @Override
    public String toString() {
        // Notice passwordHash is NEVER exposed, even in toString!
        return "PortalAccount[username=" + username + ", passwordProtected=true]";
    }
}
