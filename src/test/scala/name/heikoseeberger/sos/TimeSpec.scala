/*
 * Copyright 2013 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.heikoseeberger.sos

import org.scalatest.{ MustMatchers, ShouldMatchers, WordSpec }

class TimeSpec extends WordSpec with MustMatchers with ShouldMatchers {

  "A List of Time" when {
    val times = List(Time(1), Time(15, 30), Time(20, 15))
    "filtered by greater or equal noon" should {
      "not contain any Time earlier than noon" in {
        times filter (_ >= Time(12)) must be ===
          List(Time(15, 30), Time(20, 15))
      }
    }
    "mapped by extracting the hours" should {
      "be transformed into a List [Int] with the respective hour values" in {
        times map (_.hours) must be === List(1, 15, 20)
      }
    }
    "given invalid arguments" should {
      "throw IllegalArgumentException" in {
        intercept[IllegalArgumentException] {
          val time = Time(-1, 0, 0)
        }
        intercept[IllegalArgumentException] {
          val time = Time(24, 0, 0)
        }
        intercept[IllegalArgumentException] {
          val time = Time(0, 60, 0)
        }
        intercept[IllegalArgumentException] {
          val time = Time(0, 0, 70)
        }
      }
    }
    "time formats" should {
      "display correctly" in {
        val time1 = Time(9)
        assert("09:00:00".equals(time1.toString))

        val time2 = Time(9, 30)
        assert("09:30:00".equals(time2.toString))

        val time3 = Time(9, 30, 45)
        assert("09:30:45".equals(time3.toString))
      }
    }
  }
}
