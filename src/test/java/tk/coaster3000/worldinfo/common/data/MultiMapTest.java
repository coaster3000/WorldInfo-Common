/**
 * This file is part of WorldInfo, licensed under the MIT License (MIT).
 *
 * Copyright (c) WorldInfo
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.coaster3000.worldinfo.common.data;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tk.coaster3000.worldinfo.util.StringUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MultiMapTest {
	static Pair<String, Integer> testInt1;
	static Pair<String, String> testString1;
	static Pair<String, Object> testRaw1;
	static String testNode;
	static Pair<String, Integer> testSubInt1;
	static Pair<String, String> testSubString1;

	MultiMap<HashMap<String, Object>> data;

	@BeforeClass
	public static void setupClass() {
		testRaw1 = new Pair<String, Object>().first("testraw").second(new Object());
		testInt1 = new Pair<String, Integer>().first("test").second(50);
		testString1 = new Pair<String, String>().first("test-2").second("OMG");
		testNode = "testnode";
		testSubInt1 = new Pair<String, Integer>().first(testNode + "." + testInt1.first).second(testInt1.second);
		testSubString1 = new Pair<String, String>().first(testNode + "." + testString1.first).second(testString1.second);
	}

	@Test(description = "Initializes the multimap object for usage of other tests. All tests will fail if this fails.",
			priority = -1,
			groups = {"setup"}
	)
	public void initMultiMap() {
		data = new MultiMap<HashMap<String, Object>>() {
			@Override
			protected HashMap<String, Object> craftDataHolder() {
				return new HashMap<String, Object>();
			}
		};
	}

	@Test(description = "Tests to ensure that data can be stored in the internal map found in the MultiMap",
			dependsOnGroups = {"setup"}
	)
	public void addRaw() {
		data.set(testRaw1.first, testRaw1.second);

		assert data.contains(testRaw1.first) : String.format("Expected the node '%s' to exist", testRaw1.first);
		assert data.get(testRaw1.first).equals(testRaw1.second) : String.format("Expected the node '%s' to equal '%s'", testRaw1.first,
				testRaw1.second
						.toString());
	}

	@Test(description = "Ensures the test node is usable.",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"internalNodeCheck"},
			groups = {"nodes"}
	)
	public void addRawToNode() {
		MultiMap<HashMap<String, Object>> node = data.getNode(testNode);
		assert node != null : "Node does not exist! Critical test error! addNode should not have passed! Thus this would have never run!";

		node.set(testRaw1.first, testRaw1.second);
		assert data.contains(testNode + "." + testRaw1.first) : String.format("Expected the node '%s' to exist!", testNode + "." + testRaw1.first);
		assert node.contains(testRaw1.first) : String.format("Expected the node '%s' to exist", testRaw1.first);
		assert node.get(testRaw1.first).equals(testRaw1.second) : String.format("Expected the node '%s' to equal '%s'", testRaw1.first, testRaw1
				.second.toString());
	}

	@Test(description = "Tests to ensure strings are stored correctly. ",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"addRaw"},
			groups = {"strings"}
	)
	public void addString() {
		data.set(testString1.first, testString1.second);
		assert data.contains(testString1.first) : String.format("Expected the node'%s' to exist but it doesn't!", testString1.first);
		assert data.get(testString1.first) instanceof String :
				String.format("Expected the node'%s' to be of type string but found '%s'!", testString1.first,
						data.get(testString1.first).getClass().getName());
	}

	@Test(description = "Checks the previous addString test for its stored values.",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"addString"},
			groups = {"strings"}
	)
	public void addStringCheck() {
		String ret = data.get(testString1.first, String.class);
		assert ret != null : "Expected a non null value!";
		assert ret.equals(testString1.second) : String.format("Expected return value to equal '%s' but got '%s'!", testString1.second, ret);
	}


	@Test(description = "Tests to ensure subnode strings are stored correctly. ",
			dependsOnGroups = {"nodes"},
			dependsOnMethods = {"addRawToNode"},
			groups = {"subStrings"}
	)
	public void addSubString() {
		data.set(testSubString1.first, testSubString1.second);
		assert data.contains(testSubString1.first) : String.format("Expected the node'%s' to exist but it doesn't!", testSubString1.first);
		assert data.get(testSubString1.first) instanceof String :
				String.format("Expected the node'%s' to be of type string but found '%s'!", testSubString1.first,
						data.get(testSubString1.first).getClass().getName());
	}

	@Test(description = "Checks the previous addSubString test for its stored values.",
			dependsOnGroups = {"nodes"},
			dependsOnMethods = {"addSubString"},
			groups = {"subStrings"}
	)
	public void addSubStringCheck() {
		String ret = data.get(testSubString1.first, String.class);
		assert ret != null : "Expected a non null value!";
		assert ret.equals(testSubString1.second) : String.format("Expected return value to equal '%s' but got '%s'!", testSubString1.second, ret);
	}


	@Test(description = "Tests to ensure integers are stored correctly. ",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"addRaw"},
			groups = {"integers"}
	)
	public void addInt() {
		data.set(testInt1.first, testInt1.second);
		assert data.contains(testInt1.first) : String.format("Expected the node'%s' to exist but it doesn't!", testInt1.first);
		assert data.get(testInt1.first) instanceof Integer :
				String.format("Expected the node'%s' to be of type int but found '%s'!", testInt1.first,
						data.get(testInt1.first).getClass().getName());
	}

	@Test(description = "Checks the previous addInt test for its stored values.",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"addInt"},
			groups = {"integers"}
	)
	public void addIntCheck() {
		Integer ret = data.get(testInt1.first, Integer.class);
		assert ret != null : "Expected a non null value!";
		assert (int) ret == testInt1.second : String.format("Expected return value to equal '%s' but got '%s'!", testInt1.second, ret);
	}

	@Test(description = "Tests creating int data on subnodes.",
			dependsOnGroups = {"setup", "nodes", "integers"},
			groups = {"subIntegers"}
	)
	public void addSubInt() {
		data.set(testSubInt1.first, testSubInt1.second);
		assert data.contains(testSubInt1.first) : String.format("Expected the node'%s' to exist but it doesn't!", testSubInt1.first);
		assert data.get(testSubInt1.first) instanceof Integer :
				String.format("Expected the node'%s' to be of type int but found '%s'!", testSubInt1.first,
						data.get(testSubInt1.first).getClass().getName());
	}

	@Test(description = "Checks the previous addSubInt test for its stored values.",
			dependsOnGroups = {"setup", "nodes", "integers"},
			dependsOnMethods = {"addSubInt"},
			groups = {"subIntegers"}
	)
	public void addSubIntCheck() {
		Integer ret = data.get(testSubInt1.first, Integer.class);
		assert ret != null : "Expected a non null value!";
		assert (int) ret == testSubInt1.second : String.format("Expected return value to equal '%s' but got '%s'!", testSubInt1.second, ret);
	}

	@Test(description = "Ensures that nodes are stored correctly in internal data. ",
			dependsOnGroups = {"setup"},
			groups = {"nodes"}
	)
	public void addNode() {
		data.createNode(testNode);
	}

	@Test(description = "Ensures the addNode test has the internal data structure set up properly!",
			dependsOnGroups = {"setup"},
			dependsOnMethods = {"addNode"},
			groups = {"nodes"}
	)
	public void internalNodeCheck() {
		assert data.getData().containsKey(testNode) : String.format("Internal map does not contain '%s'!", testNode);
		assert data.getData().get(testNode) instanceof MultiMap :
				String.format("Internal map does not contain a proper subnode. Its of the wrong type! \nExpected '%s' but got %s'!",
						MultiMap.class.getName(), data.getData().get(testNode).getClass().getName());
	}

	@Test(description = "Ensures the getting the root node will result in such." ,
			dependsOnGroups = {"nodes"}
	)
	public void testGetRoot() {
		MultiMap<HashMap<String, Object>> node = data.getNode(testNode);

		assert node != null : "Node should not have been null!";
		assert node.getRoot() == data : "Node is not returning root node.";
	}

	@Test(description = "Tests that all keys are returned.",
			dependsOnGroups = {"setup", "nodes", "integers", "strings",
					"subIntegers", "subStrings"
			},
			groups = {"keys"}
	)
	public void testAllKeys() {
		Collection<String> keys = data.getKeys(true);

		String failMsg = "Keys expected to contain '%s' but didn't. It contains the following: \n\n %s \n\n";
		assert keys.contains(testNode) : String.format(failMsg, testNode, StringUtil.join("\n", keys));
		assert keys.contains(testRaw1.first) : String.format(failMsg, testRaw1.first, StringUtil.join("\n", keys));
		assert keys.contains(testInt1.first) : String.format(failMsg, testInt1.first, StringUtil.join("\n", keys));
		assert keys.contains(testString1.first) : String.format(failMsg, testString1.first, StringUtil.join("\n", keys));
		assert keys.contains(testSubInt1.first) : String.format(failMsg, testSubInt1.first, StringUtil.join("\n", keys));
		assert keys.contains(testSubString1.first) : String.format(failMsg, testSubString1.first, StringUtil.join("\n", keys));
	}

	@Test(description = "Tests that node keys are returned with no additional keys.",
			dependsOnMethods = {"testAllKeys"},
			groups = {"keys"}
	)
	public void testNodeKeys() {
		Collection<String> keys = data.getNodeKeys();

		String failMsg = "Keys expected %s contain '%s'. It contains the following: \n\n %s \n\n";
		assert keys.contains(testNode) : String.format(failMsg, "to", testNode, StringUtil.join("\n", keys));
		assert !keys.contains(testRaw1.first) : String.format(failMsg, "not to", testRaw1.first, StringUtil.join("\n", keys));
		assert !keys.contains(testInt1.first) : String.format(failMsg, "not to", testInt1.first, StringUtil.join("\n", keys));
		assert !keys.contains(testString1.first) : String.format(failMsg, "not to", testString1.first, StringUtil.join("\n", keys));
		assert !keys.contains(testSubInt1.first) : String.format(failMsg, "not to", testSubInt1.first, StringUtil.join("\n", keys));
		assert !keys.contains(testSubString1.first) : String.format(failMsg, "not to", testSubString1.first, StringUtil.join("\n", keys));
	}

	@Test(description = "Tests that value keys are returned with no additional keys.",
			dependsOnMethods = {"testAllKeys"},
			groups = {"keys"}
	)
	public void testValueKeys() {
		Collection<String> keys = data.getValueKeys();

		String failMsg = "Keys expected %s contain '%s'. It contains the following: \n\n %s \n\n";
		assert !keys.contains(testNode) : String.format(failMsg, "not to", testNode, StringUtil.join("\n", keys));
		assert keys.contains(testRaw1.first) : String.format(failMsg, "to", testRaw1.first, StringUtil.join("\n", keys));
		assert keys.contains(testInt1.first) : String.format(failMsg, "to", testInt1.first, StringUtil.join("\n", keys));
		assert keys.contains(testString1.first) : String.format(failMsg, "to", testString1.first, StringUtil.join("\n", keys));
		assert keys.contains(testSubInt1.first) : String.format(failMsg, "to", testSubInt1.first, StringUtil.join("\n", keys));
		assert keys.contains(testSubString1.first) : String.format(failMsg, "to", testSubString1.first, StringUtil.join("\n", keys));
	}

	@Test(description = "Ensures that objects can be removed from multimap.",
			priority = 3,
			dependsOnGroups = {"keys"}
	)
	public void testRemoveRaw() {
		assert data.remove(testRaw1.first);
		assert !data.getData().containsKey(testRaw1.first) :
				String.format("Data was not removed successfully. The node '%s' was not removed!", testRaw1.first);
	}

	@Test(description = "Ensures all data was erased!",
			dependsOnGroups = {"keys"},
			dependsOnMethods = {"testRemoveRaw"}
	)
	public void testClear() {
		data.clear();

		Set<String> keys = data.getKeys(true);
		String failMsg = "There should be no data left after a clear!. It contains the following: \n\n %s \n\n";
		assert keys.isEmpty() : String.format(failMsg, StringUtil.join("\n", keys));
	}

	private static class Pair<T, T2> {
		public T first;
		public T2 second;

		public Pair<T, T2> first(T value) {
			this.first = value;
			return this;
		}

		public Pair<T, T2> second(T2 value) {
			this.second = value;
			return this;
		}

		public T2 second() {
			return second;
		}

		public T first() {
			return first;
		}
	}
}