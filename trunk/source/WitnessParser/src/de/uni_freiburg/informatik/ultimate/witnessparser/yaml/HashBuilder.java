package de.uni_freiburg.informatik.ultimate.witnessparser.yaml;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calculate hashes using different default algorithms.
 * 
 * @author Manuel Bentele
 */
public class HashBuilder {
	private final MessageDigest mDigest;

	private HashBuilder(MessageDigest md) {
		mDigest = md;
	}

	private static HashBuilder fromAlgorithm(final String algorithm) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance(algorithm);
		return new HashBuilder(md);
	}

	public static HashBuilder SHA1() throws NoSuchAlgorithmException {
		return HashBuilder.fromAlgorithm("SHA-1");
	}

	public static HashBuilder SHA256() throws NoSuchAlgorithmException {
		return HashBuilder.fromAlgorithm("SHA-256");
	}

	public String hash(final String input) {
		byte[] rawHash = mDigest.digest(input.getBytes(StandardCharsets.UTF_8));
		final String encodedHash = new String(bytesToHex(rawHash));
		return encodedHash;
	}

	private static String bytesToHex(byte[] hash) {
		final StringBuilder hexString = new StringBuilder(2 * hash.length);

		for (int i = 0; i < hash.length; i++) {
			final String hex = Integer.toHexString(0xff & hash[i]);

			if (hex.length() == 1) {
				hexString.append('0');
			}

			hexString.append(hex);
		}

		return hexString.toString();
	}
}
