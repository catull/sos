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

import org.scalatest.{ MustMatchers, WordSpec }

class TimeSpec extends WordSpec with MustMatchers {

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
  }
}
