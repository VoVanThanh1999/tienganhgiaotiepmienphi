import { Component } from '@angular/core';

@Component({
  selector: 'app-speaking-practice',
  templateUrl: './speaking-practice.component.html',
  styleUrls: ['./speaking-practice.component.scss'],
})
export class SpeakingPracticeComponent {
  showSample = false;
  recording = false;
  seconds = 0;
  timer: any;

  lesson = {
    level: 'Beginner',
    duration: '30s',
    topic: 'Giới thiệu bản thân nơi làm việc',
    prompt: '🗣 Hãy giới thiệu ngắn gọn về bản thân và công việc của bạn.',
    sample: `Hi, my name is John. I work as a software developer.
I enjoy learning new things and working with my team.`,
  };

  toggleSample() {
    this.showSample = !this.showSample;
  }

  toggleRecord() {
    this.recording = !this.recording;

    if (this.recording) {
      this.seconds = 0;
      this.timer = setInterval(() => {
        this.seconds++;
      }, 1000);
    } else {
      clearInterval(this.timer);
    }
  }

  get time(): string {
    return `00:${this.seconds.toString().padStart(2, '0')}`;
  }
}
