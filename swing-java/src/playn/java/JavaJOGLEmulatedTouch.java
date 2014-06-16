/**
 * Copyright 2014 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.java;

import playn.core.Mouse;

import javax.media.opengl.awt.GLJPanel;

class JavaJOGLEmulatedTouch extends JavaEmulatedTouch {

  private final GLJPanel panel;

  public JavaJOGLEmulatedTouch(GLJPanel panel) {
    this.panel = panel;
  }

  @Override
  JavaMouse createMouse(JavaPlatform platform) {
    return new JavaJOGLMouse(platform, panel) {

      @Override public boolean hasMouse() {
        return false;
      }

      @Override protected boolean onMouseDown(Mouse.ButtonEvent.Impl event) {
        JavaJOGLEmulatedTouch.this.onMouseDown(event.time(), event.x(), event.y());
        return false;
      }

      @Override protected boolean onMouseMove(Mouse.MotionEvent.Impl event) {
        JavaJOGLEmulatedTouch.this.onMouseMove(event.time(), event.x(), event.y());
        return false;
      }

      @Override protected boolean onMouseUp(Mouse.ButtonEvent.Impl event) {
        JavaJOGLEmulatedTouch.this.onMouseUp(event.time(), event.x(), event.y());
        return false;
      }

      @Override protected boolean onMouseWheelScroll(playn.core.Mouse.WheelEvent.Impl event) {
        return false;
      }
    };
  }
}
