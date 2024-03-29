/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * CRC64 implementation for AzureBlobFileSystem.
 */
public class CRC64 {

    private static final long POLY = 0x9a6c9329ac4bc9b5L;
    private static final int TABLE_LENGTH = 256;
    private static final long[] TABLE = new long[TABLE_LENGTH];

    private static long value = -1;

    private static void init() { // Initialize a table constructed from POLY (0x9a6c9329ac4bc9b5L).
        value = -1;
        for (int n = 0; n < TABLE_LENGTH; ++n) {
            long crc = n;
            for (int i = 0; i < 8; ++i) {
                if ((crc & 1) == 1) {
                    crc = (crc >>> 1) ^ POLY;
                } else {
                    crc >>>= 1;
                } // if
            } // for i
            TABLE[n] = crc;
        } // for n
    } // init()

    /**
     * @param input byte arrays.
     * @return long value of the CRC-64 checksum of the data.
     * */
    public static long compute(byte[] input) {
        init();
        for (byte b : input) {
            value = TABLE[(b ^ (int) value) & 0xFF] ^ (value >>> 8);
        } // for i
        return ~value;
    } // compute()

} // class CRC64